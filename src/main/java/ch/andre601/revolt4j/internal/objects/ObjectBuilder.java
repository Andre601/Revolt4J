package ch.andre601.revolt4j.internal.objects;

import ch.andre601.revolt4j.api.Revolt4J;
import ch.andre601.revolt4j.api.objects.User;
import ch.andre601.revolt4j.internal.Revolt4JImpl;
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
    
    public User createUser(JSONObject json){
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
}
