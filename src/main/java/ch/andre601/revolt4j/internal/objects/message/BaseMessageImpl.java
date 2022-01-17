package ch.andre601.revolt4j.internal.objects.message;

import ch.andre601.revolt4j.api.objects.message.BaseMessage;
import ch.andre601.revolt4j.api.objects.message.TextEmbed;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BaseMessageImpl implements BaseMessage{
    
    private final String id;
    private final String content;
    private final List<TextEmbed> embeds = new ArrayList<>();
    
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
    
    @Override
    public @NotNull List<TextEmbed> getEmbeds(){
        return embeds;
    }
}
