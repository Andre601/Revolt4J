package ch.andre601.revolt4j.api.event.connection;

import ch.andre601.revolt4j.api.Revolt4J;
import ch.andre601.revolt4j.api.event.BaseEvent;

public class PongEvent extends BaseEvent{
    
    public PongEvent(Revolt4J api){
        super(api);
    }
}
