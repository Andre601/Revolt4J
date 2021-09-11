package ch.andre601.revolt4j.api.event;

import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface EventListener{
    
    void onEvent(@NotNull BaseEvent event);
}
