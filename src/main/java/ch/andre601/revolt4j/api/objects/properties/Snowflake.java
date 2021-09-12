package ch.andre601.revolt4j.api.objects.properties;

import org.jetbrains.annotations.NotNull;

/**
 * Interface for objects to implement, that all have a guaranteed unique ID.
 */
public interface Snowflake{
    
    /**
     * The unique ID that the inheriting Object has.
     * 
     * @return Never-null String representing the Object's unique ID.
     */
    @NotNull
    String getId();
}
