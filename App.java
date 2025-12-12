import DashBord.Dashboard;
import Event.Event;
import EventTypeStartegy.EventType;
import EventTypeStartegy.EventTypeFactory;
import Observer.EventObserver;
import Logger.TimeLogger;
import Logger.cocsoleLogger;
import Logger.ILogger;
import Processer.EventProcessor;
import Processer.EventProcessorProxy;
import Processer.IEventProcessor;
import Strategy.AddMetadataStrategy;
import Strategy.CompressStrategy;
import Strategy.EncStrategy;
import Strategy.EventProcessingStrategy;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        ILogger logger = new TimeLogger(new cocsoleLogger());
        Dashboard dashboard = new Dashboard(logger);

        EventObserver eventObserver = new EventObserver();
        eventObserver.addObserver(dashboard);
        eventObserver.addObserver((event) -> logger.LogMessage("[Observer]  received Event: " + event.getId()));

        EventTypeFactory typeFactory = new EventTypeFactory();
        IEventProcessor realProcessor = new EventProcessor(logger, typeFactory, eventObserver);
        EventProcessorProxy proxyProcessor = new EventProcessorProxy(realProcessor, logger);

        List<EventProcessingStrategy> strategies = new ArrayList<>();
        strategies.add(new AddMetadataStrategy("user-42"));
        strategies.add(new EncStrategy());
        strategies.add(new CompressStrategy());

        Event e1 = new Event(EventType.USER, "user-click", 1);
        Event e2 = new Event(EventType.SYSTEM, "system-update", 2);
        Event e3 = new Event(EventType.SECURITY, "hack-attempt", 3);

        processWithLogging(proxyProcessor, e1, strategies);
        processWithLogging(proxyProcessor, e2, strategies);
        processWithLogging(proxyProcessor, e3, strategies);
    }

    private static void processWithLogging(IEventProcessor processor, Event e, List<EventProcessingStrategy> strategies) {
        System.out.println("\n--- Processing Event " + e.getId() + " | Type: " + e.getType() + " ---");

        System.out.println("Step 1: Proxy check / security filtering");
        processor.process(e, strategies);
        System.out.println("--- Finished Event " + e.getId() + " ---\n");
    }
}
