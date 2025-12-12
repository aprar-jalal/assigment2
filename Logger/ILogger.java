package Logger;

import Event.Event;

public  interface ILogger {
    void Log(Event event);
    void LogMessage(String message);
}
