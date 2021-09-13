package ch.andre601.revolt4j.internal.objects;

import ch.andre601.revolt4j.api.Revolt4J;
import ch.andre601.revolt4j.api.objects.User;
import org.jetbrains.annotations.NotNull;

public class UserImpl implements User{
    
    protected final Revolt4J api;
    
    protected final String id;
    protected String name;
    protected int badges;
    protected Avatar avatar;
    
    public UserImpl(Revolt4J api, String id){
        this.api = api;
        
        this.id = id;
    }
    
    @Override
    @NotNull
    public String getId(){
        return id;
    }
    
    @Override
    public String getAsMention(){
        return "<@" + getId() + ">";
    }
    
    @Override
    @NotNull
    public String getName(){
        return name;
    }
    
    @Override
    @NotNull
    public Avatar getAvatar(){
        return avatar;
    }
    
    @Override
    @NotNull
    public String getAvatarUrl(){
        return getAvatar().getUrl();
    }
    
    public UserImpl setName(@NotNull String name){
        this.name = name;
        return this;
    }
    
    public UserImpl setBadges(int badges){
        this.badges = badges;
        return this;
    }
    
    public UserImpl setAvatar(Avatar avatar){
        this.avatar = avatar;
        return this;
    }
    
    public static class AvatarImpl implements Avatar{
        
        private final Revolt4J api;
        
        private final String id;
        
        public AvatarImpl(Revolt4J api, String id){
            this.api = api;
            
            this.id = id;
        }
        
        @Override
        @NotNull
        public String getId(){
            return id;
        }
    
        @Override
        @NotNull
        public String getUrl(){
            return api.getFileUrl() + "/avatars/" + getId();
        }
    }
}
