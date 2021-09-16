package ch.andre601.revolt4j.internal.objects;

import ch.andre601.revolt4j.api.Revolt4J;
import ch.andre601.revolt4j.api.objects.User;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.Map;

public class UserImpl implements User{
    
    protected final Revolt4J api;
    
    protected final String id;
    protected String name;
    protected Avatar avatar;
    protected int badges;
    protected Status status;
    protected Relationship relationship;
    protected boolean online;
    protected int flags;
    
    public UserImpl(Revolt4J api, String id){
        this.api = api;
        
        this.id = id;
    }
    
    @Override
    public @NotNull String getId(){
        return id;
    }
    
    @Override
    public @NotNull String getAsMention(){
        return "<@" + getId() + ">";
    }
    
    @Override
    public @NotNull String getName(){
        return name;
    }
    
    @Override
    public @NotNull Avatar getAvatar(){
        return avatar;
    }
    
    @Override
    public @NotNull String getAvatarUrl(){
        return getAvatar().getUrl();
    }
    
    @NotNull
    @Override
    public EnumSet<Badge> getBadges(){
        return Badge.getBadges(badges);
    }
    
    @Override
    public int getBadgesRaw(){
        return 0;
    }
    
    @Override
    public @NotNull Status getStatus(){
        return status;
    }
    
    @Override
    public @NotNull Relationship getRelationship(){
        return relationship;
    }
    
    @Override
    public boolean isOnline(){
        return online;
    }
    
    @Override
    public @NotNull EnumSet<Flag> getFlags(){
        return Flag.getFlags(flags);
    }
    
    @Override
    public int getFlagsRaw(){
        return flags;
    }
    
    public UserImpl setName(@NotNull String name){
        this.name = name;
        return this;
    }
    
    public UserImpl setAvatar(Avatar avatar){
        this.avatar = avatar;
        return this;
    }
    
    public UserImpl setBadges(int badges){
        this.badges = badges;
        return this;
    }
    
    public UserImpl setStatus(@NotNull Status status){
        this.status = status;
        return this;
    }
    
    public UserImpl setRelationship(@NotNull Relationship relationship){
        this.relationship = relationship;
        return this;
    }
    
    public UserImpl setOnline(boolean online){
        this.online = online;
        return this;
    }
    
    public UserImpl setFlags(int flags){
        this.flags = flags;
        return this;
    }
    
    public static class AvatarImpl implements Avatar{
        
        private final Revolt4J api;
        
        private final String id;
        private int size;
        private String fileName;
        private Map<String, Object> metadata;
        private String contentType;
        
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
    
        @Override
        public @NotNull Revolt4J getRevolt4J(){
            return api;
        }
    
        @Override
        public @NotNull Tag getTag(){
            return Tag.AVATARS;
        }
    
        @Override
        public int getSize(){
            return size;
        }
    
        @Override
        public @NotNull String getFileName(boolean withExtension){
            return fileName;
        }
    
        @Override
        public @NotNull Map<String, Object> getMetadata(){
            return metadata;
        }
    
        @Override
        public @NotNull String getContentType(){
            return contentType;
        }
        
        public AvatarImpl setSize(int size){
            this.size = size;
            return this;
        }
        
        public AvatarImpl setFileName(String fileName){
            this.fileName = fileName;
            return this;
        }
        
        public AvatarImpl setMetadata(Map<String, Object> metadata){
            this.metadata = metadata;
            return this;
        }
        
        public AvatarImpl setContentType(String contentType){
            this.contentType = contentType;
            return this;
        }
    }
    
    public static class StatusImpl implements Status{
    
        private final String text;
        private final PresenceType presence;
        
        public StatusImpl(@Nullable String text, @NotNull PresenceType presence){
            this.text = text;
            this.presence = presence;
        }
        
        @Override
        public @Nullable String getText(){
            return text;
        }
    
        @Override
        public @NotNull PresenceType getPresence(){
            return presence;
        }
    }
}
