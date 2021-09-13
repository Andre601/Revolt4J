package ch.andre601.revolt4j.api.objects.server;

import ch.andre601.revolt4j.api.objects.User;
import ch.andre601.revolt4j.api.objects.properties.Snowflake;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * A Revolt Server.
 * 
 * <p>The Server is a place containing TextChannels, VoiceChannels, Roles and other Server Members.
 */
public interface Server extends Snowflake{
    
    /**
     * The unique ID the server has.
     * 
     * @return The Server's ID.
     */
    @NotNull
    String getId();
    
    List<Channel> getChannels();
    
    List<User> getUsers();
}
