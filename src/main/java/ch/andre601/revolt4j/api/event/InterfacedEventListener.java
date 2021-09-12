package ch.andre601.revolt4j.api.event;

import ch.andre601.revolt4j.api.event.connection.ConnectionReadyEvent;
import ch.andre601.revolt4j.api.event.message.BaseMessageEvent;
import ch.andre601.revolt4j.api.event.message.ServerMessageEvent;
import org.jetbrains.annotations.NotNull;

public abstract class InterfacedEventListener implements EventListener{
    
    // Connection Events
    public void onPong(){}
    public void onReady(ConnectionReadyEvent event){}
    
    // Message Events
    public void onBaseMessage(BaseMessageEvent event){}
    public void onServerMessage(ServerMessageEvent event){}
}
