package ch.andre601.revolt4j.api.event;

import ch.andre601.revolt4j.api.Revolt4J;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractEvent implements BaseEvent{
    
    protected final Revolt4J api;
    
    public AbstractEvent(@NotNull Revolt4J api){
        this.api = api;
    }
    
    @Override
    public @NotNull Revolt4J getRevolt4J(){
        return api;
    }
    
}
