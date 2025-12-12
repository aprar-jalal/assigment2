package Logger;

import Event.Event;
import Observer.IObserver;

public class cocsoleLogger implements ILogger , IObserver {
    @Override
    public void Log(Event event){
        System.out.println("[LOGGER] Event Id: " + event.getId() + " | Type: " + event.getType() + " | Payload: " + event.getPayload());
    }
    @Override
    public void LogMessage(String message) {
        System.out.println(message);
    }
    @Override
    public void update(Event event){
        Log(event);
    }
}
