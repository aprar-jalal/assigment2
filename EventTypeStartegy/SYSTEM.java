package EventTypeStartegy;

import Event.Event;
import Logger.ILogger;

public class SYSTEM implements EvTypeStrategy {
    @Override
    public void execute(Event event, ILogger logger) {
        logger.LogMessage("[EventTypeStartegy.SYSTEM] system audit log " + event.getId());
    }
}
