package Event;

public interface IEvent extends Cloneable {
    IEvent clone(int newId);
}
