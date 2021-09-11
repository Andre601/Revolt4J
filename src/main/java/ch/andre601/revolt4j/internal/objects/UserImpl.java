package ch.andre601.revolt4j.internal.objects;

import ch.andre601.revolt4j.api.Revolt4J;
import ch.andre601.revolt4j.api.objects.User;
import org.jetbrains.annotations.NotNull;

public class UserImpl implements User{
    
    protected final Revolt4J api;
    
    protected final String id;
    protected String name;
    protected int badges;
    
    public UserImpl(Revolt4J api, String id){
        this.api = api;
        
        this.id = id;
    }
    
    @Override
    public String getId(){
        return id;
    }
    
    @Override
    public String getName(){
        return name;
    }
    
    public UserImpl setName(@NotNull String name){
        this.name = name;
        return this;
    }
    
    public UserImpl setBadges(int badges){
        this.badges = badges;
        return this;
    }
}
