package ch.andre601.revolt4j.internal.objects;

import ch.andre601.revolt4j.api.Revolt4J;
import ch.andre601.revolt4j.api.objects.message.BaseFile;
import ch.andre601.revolt4j.api.objects.User;
import ch.andre601.revolt4j.api.objects.message.TextEmbed;
import ch.andre601.revolt4j.internal.Revolt4JImpl;
import ch.andre601.revolt4j.internal.objects.message.BaseFileImpl;
import ch.andre601.revolt4j.internal.objects.message.TextEmbedImpl;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.Map;

public class ObjectBuilder{
    
    protected final Revolt4JImpl api;
    
    public ObjectBuilder(Revolt4J api){
        this.api = (Revolt4JImpl)api;
    }
    
    public Revolt4JImpl getRevolt4J(){
        return api;
    }
    
    public User createUser(@NotNull JSONObject json){
        final String id = json.getString("_id");
        final String username = json.getString("username");
        
        // Avatar object
        final JSONObject avatarJson = json.getJSONObject("avatar");
        final String avatarId = avatarJson.getString("_id");
        final int size = avatarJson.getInt("size");
        final Map<String, Object> metadata = avatarJson.getJSONObject("metadata").toMap();
        final String contentType = avatarJson.getString("content_type");
        
        final int badges = json.getInt("badges");
        
        // Status Object
        final JSONObject statusJson = json.getJSONObject("status");
        final String text = statusJson.optString("text", null);
        final User.PresenceType presence = User.PresenceType.getFromString(statusJson.getString("presence"));
        
        final User.Relationship relationship = User.Relationship.getFromString(json.getString("relationship"));
        final boolean online = json.getBoolean("online");
        final int flags = json.getInt("flags");
    
        UserImpl.AvatarImpl avatar = new UserImpl.AvatarImpl(getRevolt4J(), avatarId)
            .setSize(size)
            .setMetadata(metadata)
            .setContentType(contentType);
    
        UserImpl.StatusImpl status = new UserImpl.StatusImpl(text, presence);
        
        return new UserImpl(getRevolt4J(), id)
            .setName(username)
            .setAvatar(avatar)
            .setBadges(badges)
            .setStatus(status)
            .setRelationship(relationship)
            .setOnline(online)
            .setFlags(flags);
    }
    
    public BaseFile createBaseFile(@NotNull JSONObject json){
        final String id = json.getString("_id");
        
        final BaseFile.Tag tag = BaseFile.Tag.getFromString(json.getString("tag"));
        final int size = json.getInt("size");
        final String filename = json.getString("filename");
        final Map<String, Object> metadata = json.getJSONObject("metadata").toMap();
        final String contentType = json.getString("contentType");
        
        return new BaseFileImpl(getRevolt4J(), id)
            .setTag(tag)
            .setSize(size)
            .setFilename(filename)
            .setMetadata(metadata)
            .setContentType(contentType);
    }
    
    public static TextEmbed createTextEmbed(String iconUrl, String url, String title, String description, String media, String colour){
        return new TextEmbedImpl(iconUrl, url, title, description, media, colour);
    }
}
