package ch.andre601.revolt4j.api.objects.server;

import ch.andre601.revolt4j.api.objects.properties.Mentionable;
import ch.andre601.revolt4j.api.objects.properties.Snowflake;
import org.jetbrains.annotations.NotNull;

/**
 * A generic Server Channel.
 * 
 * <p>The Channel instance can be both a {@link TextChannel} or {@link VoiceChannel}.
 * <br>To find out which you have can you check the {@link #getType() ChannelType} the Channel will have.
 */
public interface Channel extends Mentionable, Snowflake{
    
    @NotNull
    String getName();
    
    @NotNull
    ChannelType getType();
    
    enum ChannelType{
        TEXT,
        VOICE
    }
}
