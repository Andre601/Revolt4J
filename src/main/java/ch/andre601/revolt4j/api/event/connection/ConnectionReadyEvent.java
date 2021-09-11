package ch.andre601.revolt4j.api.event.connection;

import ch.andre601.revolt4j.api.Revolt4J;
import ch.andre601.revolt4j.api.event.BaseEvent;

public class ConnectionReadyEvent extends BaseEvent{
    
    public ConnectionReadyEvent(Revolt4J api){
        super(api);
    }
}
