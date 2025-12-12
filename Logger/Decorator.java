package Logger;

import Logger.ILogger;

public abstract class Decorator implements ILogger {
    protected final ILogger wrappee;
    public Decorator(ILogger wrappee){
        this.wrappee = wrappee;
    }
}
