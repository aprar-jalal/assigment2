package Observer;


import Event.Event;

import java.util.ArrayList;
import java.util.List;


public class EventObserver {
    private final List<IObserver> observers = new ArrayList<>();

    public void addObserver(IObserver o){
        observers.add(o);
    }
    public void removeObserver(IObserver o){
        observers.remove(o);
    }

    public void notifyObservers(Event event){
        System.out.println("[EventObserver] Notifying " + observers.size() + " observers for Event " + event.getId());
        for(IObserver o : observers){
            o.update(event);
        }
    }
}
