package ch.andre601.revolt4j.internal.objects.message;

import ch.andre601.revolt4j.api.objects.BaseMessage;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class BaseMessageImpl implements BaseMessage{
    
    private final String id;
    private final String content;
    
    public BaseMessageImpl(@NotNull JSONObject json){
        this.id = json.getString("_id");
        this.content = json.getJSONObject("content").getString("content");
    }
    
    @Override
    public @NotNull String getId(){
        return id;
    }
    
    @Override
    public @NotNull String getContent(){
        return content;
    }
}
