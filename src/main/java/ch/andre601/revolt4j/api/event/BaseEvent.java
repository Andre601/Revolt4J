package ch.andre601.revolt4j.api.event;

import ch.andre601.revolt4j.api.Revolt4J;

/**
 * This is the most basic event.
 * <br>All events will trigger this particular event itself.
 * 
 * <p>Use the {@code instanceof} comparitor to check what type the event actually is.
 */
public abstract class BaseEvent implements GenericEventStructure{
    
    protected final Revolt4J api;
    
    public BaseEvent(Revolt4J api){
        this.api = api;
    }
    
    @Override
    public Revolt4J getRevolt4J(){
        return api;
    }
}
