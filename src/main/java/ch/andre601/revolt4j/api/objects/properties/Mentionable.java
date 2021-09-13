package ch.andre601.revolt4j.api.objects.properties;

/**
 * Marks an object as Mentionable. Mentionable objects can be mentioned in the client.
 * <br>Common examples of mentionable objects are Users or channels.
 */
public interface Mentionable{
    
    /**
     * Gives the String representing a mention for the Object.
     * 
     * @return String representing the Mention of the Object.
     */
    String getAsMention();
}
