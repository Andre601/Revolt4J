package ch.andre601.revolt4j.internal.objects.message;

import ch.andre601.revolt4j.api.objects.message.TextEmbed;
import ch.andre601.revolt4j.api.objects.message.TextEmbedBuilder;
import org.jetbrains.annotations.Nullable;

public class TextEmbedImpl implements TextEmbed{
    
    private final String iconUrl;
    private final String url;
    private final String title;
    private final String description;
    private final String media;
    private final String colour;
    
    public TextEmbedImpl(String iconUrl, String url, String title, String description, String media, String colour){
        this.iconUrl = iconUrl;
        this.url = url;
        this.title = title;
        this.description = description;
        this.media = media;
        this.colour = colour;
    }
    
    @Override
    public @Nullable String getType(){
        return TextEmbedBuilder.TEXT_EMBED_TYPE;
    }
    
    @Override
    public @Nullable String getIconUrl(){
        return iconUrl;
    }
    
    @Override
    public @Nullable String getUrl(){
        return url;
    }
    
    @Override
    public @Nullable String getTitle(){
        return title;
    }
    
    @Override
    public @Nullable String getDescription(){
        return description;
    }
    
    @Override
    public @Nullable String getMedia(){
        return media;
    }
    
    @Override
    public @Nullable String getColour(){
        return colour;
    }
}
