package ch.andre601.revolt4j.api.objects.server;

import ch.andre601.revolt4j.api.objects.properties.Mentionable;
import ch.andre601.revolt4j.api.objects.properties.Snowflake;

/**
 * A generic Server Channel.
 * <br>One instance can be both  a Text or Voice channel. Use {@link #getType()}, or
 * directly use a TextChannel or VoiceChannel instance instead.
 */
public interface Channel extends Mentionable, Snowflake{
    
    String getName();
    
    ChannelType getType();
    
    enum ChannelType{
        TEXT,
        VOICE
    }
}
