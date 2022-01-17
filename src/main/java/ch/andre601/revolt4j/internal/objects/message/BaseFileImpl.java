package ch.andre601.revolt4j.internal.objects.message;

import ch.andre601.revolt4j.api.Revolt4J;
import ch.andre601.revolt4j.api.objects.message.BaseFile;
import ch.andre601.revolt4j.internal.Revolt4JImpl;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class BaseFileImpl implements BaseFile{
    
    protected final Revolt4JImpl api;
    
    protected final String id;
    protected Tag tag = Tag.UNKNOWN;
    protected int size = 0;
    protected String fileName = "unknown";
    protected Map<String, Object> metadata = new HashMap<>();
    protected String contentType = "unknown";
    
    public BaseFileImpl(@NotNull Revolt4JImpl api, @NotNull String id){
        this.api = api;
        this.id = id;
    }
    
    @Override
    public @NotNull Revolt4J getRevolt4J(){
        return api;
    }
    
    @Override
    public @NotNull String getId(){
        return id;
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
    
    public BaseFileImpl setTag(@NotNull Tag tag){
        this.tag = tag;
        return this;
    }
    
    public BaseFileImpl setSize(int size){
        this.size = size;
        return this;
    }
    
    public BaseFileImpl setFilename(@NotNull String fileName){
        this.fileName = fileName;
        return this;
    }
    
    public BaseFileImpl setMetadata(@NotNull Map<String, Object> metadata){
        this.metadata = metadata;
        return this;
    }
    
    public BaseFileImpl setContentType(@NotNull String contentType){
        this.contentType = contentType;
        return this;
    }
    
    
}
