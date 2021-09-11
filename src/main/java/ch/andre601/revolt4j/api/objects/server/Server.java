package ch.andre601.revolt4j.api.objects.server;

import ch.andre601.revolt4j.api.objects.User;

import java.util.List;

public interface Server{
    
    List<Channel> getChannels();
    
    List<User> getUsers();
}
