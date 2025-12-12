package EventTypeStartegy;

import Event.Event;
import Logger.ILogger;

public class USER implements EvTypeStrategy {
    @Override
    public void execute(Event event, ILogger logger) {
        logger.LogMessage("[EventTypeStartegy.User] user audit log " + event.getId());
    }
}
