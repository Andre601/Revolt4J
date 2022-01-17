package ch.andre601.revolt4j.api.objects.message;

import ch.andre601.revolt4j.internal.objects.ObjectBuilder;
import org.jetbrains.annotations.NotNull;

/**
 * Convenience class to build an instance of the {@link ch.andre601.revolt4j.api.objects.message.TextEmbed TextEmbed}.
 */
public class TextEmbedBuilder{
    
    public static final String ZERO_WIDTH_SPACE = "\u200E";
    
    private String iconUrl;
    private String url;
    private String title;
    private String description;
    private String media;
    private String colour;
    
    public TextEmbedBuilder(){}
    
    public TextEmbedBuilder setIconUrl(@NotNull String iconUrl){
        this.iconUrl = iconUrl;
        return this;
    }
    
    public TextEmbedBuilder setUrl(@NotNull String url){
        this.url = url;
        return this;
    }
    
    public TextEmbedBuilder setTitle(@NotNull String title){
        this.title = title;
        return this;
    }
    
    public TextEmbedBuilder setDescription(@NotNull String description){
        this.description = description;
        return this;
    }
    
    public TextEmbedBuilder setMedia(@NotNull String media){
        this.media = media;
        return this;
    }
    
    public TextEmbedBuilder setColour(@NotNull String colour){
        this.colour = colour;
        return this;
    }
    
    public TextEmbedBuilder reset(){
        this.iconUrl = null;
        this.url = null;
        this.title = null;
        this.description = null;
        this.media = null;
        this.colour = null;
        
        return this;
    }
    
    public TextEmbed build(){
        if(isEmpty())
            throw new IllegalStateException("TextEmbed may not be empty!");
        
        return ObjectBuilder.createTextEmbed(iconUrl, url, title, description, media, colour);
    }
    
    private boolean isEmpty(){
        return iconUrl == null &&
            url == null &&
            title == null &&
            description == null &&
            media == null &&
            colour == null;
    }
}
