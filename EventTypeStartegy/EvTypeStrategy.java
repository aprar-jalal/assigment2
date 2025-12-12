package EventTypeStartegy;

import Event.Event;
import Logger.ILogger;

public interface EvTypeStrategy {
    void execute(Event event , ILogger logger);
}
