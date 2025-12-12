package Logger;

import Event.Event;

import java.time.LocalTime;

public class TimeLogger extends Decorator{
    public TimeLogger(ILogger wrappee){
        super(wrappee);
    }
        @Override
        public void Log(Event event) {
            System.out.print("[" + LocalTime.now() + "] ");
            wrappee.Log(event);
        }

        @Override
        public void LogMessage(String message) {
            String decoratedMessage = "[" + LocalTime.now() + "] " + message;
            wrappee.LogMessage(decoratedMessage);
        }
}
