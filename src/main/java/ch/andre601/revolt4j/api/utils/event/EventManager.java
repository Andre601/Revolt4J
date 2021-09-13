package ch.andre601.revolt4j.api.utils.event;

import ch.andre601.revolt4j.api.event.BaseEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface EventManager{
    
    void register(@NotNull Object listener);
    
    void unregister(@NotNull Object listener);
    
    void handle(@NotNull BaseEvent event);
    
    @NotNull
    List<Object> getRegisteredListeners();
}
