package ch.andre601.revolt4j.api.event;

import ch.andre601.revolt4j.api.event.message.BaseMessageEvent;
import org.jetbrains.annotations.NotNull;

public abstract class InterfacedEventListener implements EventListener{
    
    public void onBaseMessage(@NotNull BaseMessageEvent event){}
}
