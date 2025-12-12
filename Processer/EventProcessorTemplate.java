package Processer;

import Event.Event;
import EventTypeStartegy.EventTypeFactory;
import Logger.ILogger;
import Observer.EventObserver;
import Strategy.EventProcessingStrategy;

import java.util.List;

public abstract class EventProcessorTemplate {
    protected final ILogger logger;
    protected final EventTypeFactory typeFactory;
    protected final EventObserver eventObserver;

    public EventProcessorTemplate(ILogger logger, EventTypeFactory typeFactory, EventObserver eventObserver) {
        this.logger = logger;
        this.typeFactory = typeFactory;
        this.eventObserver = eventObserver;
    }
    public final void process(Event e, List<EventProcessingStrategy> strategies) {
        if (!validateEvent(e)) return;
        notifyObservers(e);
        String data = processStrategies(e, strategies);
        executeTypeStrategy(e, data);
    }
    protected abstract boolean validateEvent(Event e);
    protected abstract String processStrategies(Event e, List<EventProcessingStrategy> strategies);
    protected abstract void executeTypeStrategy(Event e, String data);
    private void notifyObservers(Event e) {
        eventObserver.notifyObservers(e);
    }
}
