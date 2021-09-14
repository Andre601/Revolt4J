package ch.andre601.revolt4j.api.event;

import ch.andre601.revolt4j.api.Revolt4J;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public abstract class AbstractEvent implements BaseEvent{
    
    protected final Revolt4J api;
    protected final JSONObject json;
    
    public AbstractEvent(@NotNull Revolt4J api, @NotNull JSONObject json){
        this.api = api;
        this.json = json;
    }
    
    @Override
    public @NotNull Revolt4J getRevolt4J(){
        return api;
    }
    
    @Override
    public @NotNull JSONObject getJson(){
        return json;
    }
}
