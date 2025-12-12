package Processer;

import Event.Event;
import Strategy.EventProcessingStrategy;

import java.util.List;

public interface IEventProcessor {
    void process(Event event, List<EventProcessingStrategy> strategies);

}
