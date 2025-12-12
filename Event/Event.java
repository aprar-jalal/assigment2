package Event;

import EventTypeStartegy.EventType;

public class Event implements IEvent {
    private final int id;
    private EventType type;
    private String payload;



    public Event(EventType type, String payload, int id) {
        this.type = type; this.payload = payload; this.id= id;
    }


    public IEvent clone(int newId) {
        return new Event(this.type, this.payload, newId);
    }
    public EventType getType() {
        return type;
    }

    public int getId() {
        return id;
    }


    public String getPayload() {
        return payload;
    }

}