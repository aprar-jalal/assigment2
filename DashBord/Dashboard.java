package DashBord;

import Event.Event;
import Logger.ILogger;
import Observer.IObserver;

public class Dashboard implements IObserver {
    private final ILogger logger;
    public Dashboard(ILogger logger) {
        this.logger = logger;
    }

    @Override
    public void update(Event event) {
        logger.LogMessage(String.format("[DashBord] metrics updated for %s, payload: %s", event.getId(), event.getPayload()));

    }

}
