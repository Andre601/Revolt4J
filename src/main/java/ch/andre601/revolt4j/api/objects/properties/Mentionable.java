package ch.andre601.revolt4j.api.objects.properties;

/**
 * Objects inheriting or extending this Interface can be mentioned within the Revolt Client.
 */
public interface Mentionable{
    
    /**
     * Gives the String representing a mention for the Object.
     * 
     * @return String representing the Mention of the Object.
     */
    String getAsMention();
}
