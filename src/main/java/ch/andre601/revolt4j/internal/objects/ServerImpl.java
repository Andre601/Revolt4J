package ch.andre601.revolt4j.internal.objects;

import ch.andre601.revolt4j.api.objects.User;
import ch.andre601.revolt4j.api.objects.server.Channel;
import ch.andre601.revolt4j.api.objects.server.Server;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ServerImpl implements Server{
    
    private String id;
    
    @Override
    @NotNull
    public String getId(){
        return "";
    }
    
    @Override
    public List<Channel> getChannels(){
        return null;
    }
    
    @Override
    public List<User> getUsers(){
        return null;
    }
}
