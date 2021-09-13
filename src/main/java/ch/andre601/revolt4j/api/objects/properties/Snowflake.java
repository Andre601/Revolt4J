package ch.andre601.revolt4j.api.objects.properties;

import org.jetbrains.annotations.NotNull;

/**
 * Marks a snowflake entity. Snowflake entities have unique IDs that will not appear in any other object on revolt,
 * no matter the type or time.
 * <br>This allows you to uniquely identify them.
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
