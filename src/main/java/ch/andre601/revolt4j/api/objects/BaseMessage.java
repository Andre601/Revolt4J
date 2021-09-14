package ch.andre601.revolt4j.api.objects;

import ch.andre601.revolt4j.api.objects.properties.Snowflake;
import org.jetbrains.annotations.NotNull;

public interface BaseMessage extends Snowflake{
    
    @NotNull
    String getContent();
}
