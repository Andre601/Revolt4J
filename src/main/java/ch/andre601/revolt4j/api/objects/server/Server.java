package ch.andre601.revolt4j.api.objects.server;

import ch.andre601.revolt4j.api.objects.User;
import ch.andre601.revolt4j.api.objects.properties.Snowflake;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Instance of a Revolt Server.
 */
public interface Server extends Snowflake{
    
    @NotNull
    String getId();
    
    List<Channel> getChannels();
    
    List<User> getUsers();
}
