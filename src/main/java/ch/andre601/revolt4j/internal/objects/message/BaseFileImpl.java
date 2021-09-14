package ch.andre601.revolt4j.internal.objects.message;

import ch.andre601.revolt4j.api.Revolt4J;
import ch.andre601.revolt4j.api.objects.BaseFile;
import ch.andre601.revolt4j.internal.Revolt4JImpl;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.util.Map;

public class BaseFileImpl implements BaseFile{
    
    protected final Revolt4JImpl api;
    
    protected final String id;
    protected final Tag tag;
    protected final int size;
    protected String fileName;
    protected final Map<String, Object> metadata;
    protected final String contentType;
    
    public BaseFileImpl(@NotNull Revolt4JImpl api, @NotNull JSONObject json){
        this.api = api;
        
        this.id = json.getString("_id");
        this.tag = Tag.getFromString(json.getString("tag"));
        this.size = json.getInt("size");
        this.fileName = json.getString("filename");
        this.metadata = json.getJSONObject("metadata").toMap();
        this.contentType = json.getString("content_type");
    }
    
    @Override
    public @NotNull Revolt4J getRevolt4J(){
        return api;
    }
    
    @Override
    public @NotNull Tag getTag(){
        return tag;
    }
    
    @Override
    public int getSize(){
        return size;
    }
    
    @Override
    public @NotNull String getFileName(boolean withExtension){
        if(!withExtension)
            return fileName.substring(0, fileName.lastIndexOf("."));
        
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
    
    @Override
    public @NotNull String getId(){
        return id;
    }
}
