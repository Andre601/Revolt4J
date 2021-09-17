package ch.andre601.revolt4j.api.event.message;

import ch.andre601.revolt4j.api.Revolt4J;
import ch.andre601.revolt4j.api.event.AbstractEvent;
import org.jetbrains.annotations.NotNull;

public class BaseMessageEvent extends AbstractEvent{
    
    protected final String id;
    
    public BaseMessageEvent(@NotNull Revolt4J api, @NotNull String id){
        super(api);
        this.id = id;
    }
    
    
}
