package EventTypeStartegy;

import java.util.HashMap;
import java.util.Map;

public class EventTypeFactory {

    private final Map<EventType, EvTypeStrategy> map = new HashMap<>();

    public EventTypeFactory() {
        map.put(EventType.USER, new USER());
        map.put(EventType.SYSTEM, new SYSTEM());
        map.put(EventType.SECURITY, new SECURITY());
    }

    public EvTypeStrategy get(EventType type) {
        return map.get(type);
    }
}
