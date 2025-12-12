package EventTypeStartegy;

import Event.Event;
import Logger.ILogger;

public class SECURITY implements EvTypeStrategy {
    @Override
    public void execute(Event event, ILogger logger) {
        logger.LogMessage("[EventTypeStartegy.SECURITY] extra analysis for " + event.getId());
        logger.LogMessage("[SecurityMonitor] alert for " + event.getId());
    }
}
