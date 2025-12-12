package Processer;

import Event.Event;
import EventTypeStartegy.EventType;
import Logger.ILogger;
import Strategy.EventProcessingStrategy;

import java.util.List;

public class EventProcessorProxy implements IEventProcessor {
    private final IEventProcessor real;
    private final ILogger logger;

    public EventProcessorProxy(IEventProcessor real, ILogger logger) {
        this.real = real;
        this.logger = logger;
    }

    @Override
    public void process(Event e, List<EventProcessingStrategy> pipeline) {
        logger.LogMessage("[Proxy] checking " + e.getId());

        if (e.getType() == EventType.SECURITY) {
            logger.LogMessage("[Proxy] denied security event " + e.getId());
            return;
        }

        long start = System.nanoTime();
        real.process(e, pipeline);
        long end = System.nanoTime();

        logger.LogMessage("[Proxy] finished " + e.getId() + " in " + ((end - start) / 1_000_000.0) + " ms");
    }
}
