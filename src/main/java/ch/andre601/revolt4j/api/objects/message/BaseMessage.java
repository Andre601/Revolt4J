package ch.andre601.revolt4j.api.objects.message;

import ch.andre601.revolt4j.api.objects.properties.Snowflake;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface BaseMessage extends Snowflake{
    
    /**
     * The text itself in the message. This will be the <b>raw</b> output of the markdown itself, including all
     * formatting available.
     * 
     * @return The raw, unformatted text of the message.
     */
    @NotNull
    String getContent();
    
    /**
     * Returns a List of {@link ch.andre601.revolt4j.api.objects.message.TextEmbed TextEmbeds} the message currently
     * has.
     * 
     * @return Possibly-empty List of {@link ch.andre601.revolt4j.api.objects.message.TextEmbed TextEmbeds}.
     */
    @NotNull
    List<TextEmbed> getEmbeds();
}
