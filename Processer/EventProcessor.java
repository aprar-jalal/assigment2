package Processer;


import Event.Event;
import EventTypeStartegy.EventTypeFactory;
import Logger.ILogger;
import Observer.EventObserver;
import Strategy.EventProcessingStrategy;

import java.util.List;

public class EventProcessor extends EventProcessorTemplate implements IEventProcessor  {

    public EventProcessor(ILogger logger, EventTypeFactory typeFactory, EventObserver eventObserver) {
        super(logger, typeFactory, eventObserver);
    }

    @Override
    protected boolean validateEvent(Event e) {
        if (e.getPayload() == null || e.getPayload().isEmpty()) {
            logger.LogMessage("[EventProcessor] invalid Event: " + e.getId());
            return false;
        }
        return true;
    }
    @Override
    protected String processStrategies(Event e, List<EventProcessingStrategy> strategies) {
        String data = e.getPayload();
        for (EventProcessingStrategy strategy : strategies) {
            data = strategy.process(data);
            logger.LogMessage("[Strategy] Applied " + strategy.getClass().getSimpleName() + " → payload: " + data);
        }
        return data;
    }

    @Override
    protected void executeTypeStrategy(Event e, String data) {
        typeFactory.get(e.getType()).execute(e, logger);
    }
}