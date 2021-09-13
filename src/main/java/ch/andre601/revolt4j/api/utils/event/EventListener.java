package ch.andre601.revolt4j.api.utils.event;

import ch.andre601.revolt4j.api.event.BaseEvent;
import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface EventListener{
    
    void onEvent(@NotNull BaseEvent event);
}
