package ch.andre601.revolt4j.api.objects.message;

import ch.andre601.revolt4j.internal.objects.ObjectBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Convenience class to build an instance of the {@link ch.andre601.revolt4j.api.objects.message.TextEmbed TextEmbed}.
 */
public class TextEmbedBuilder{
    
    public static final String ZERO_WIDTH_SPACE = "\u200E";
    
    public static final String TEXT_EMBED_TYPE = "text";
    
    private String iconUrl;
    private String url;
    private String title;
    private String description;
    private String media;
    private String colour;
    
    /**
     * Creates a new, blank TextEmbedBuilder to use for creating new {@link ch.andre601.revolt4j.api.objects.message.TextEmbed TextEmbeds}.
     */
    public TextEmbedBuilder(){}
    
    /**
     * Creates a new TextEmbedBuilder instance with the values already set to those defined in the provided
     * {@link ch.andre601.revolt4j.api.objects.message.TextEmbed TextEmbed}.
     * 
     * @param  embed
     *         The {@link ch.andre601.revolt4j.api.objects.message.TextEmbed TextEmbed} to copy values from.
     * 
     * @return New TextEmbedBuilder instance containing values provided by an existing TextEmbed.
     */
    public static TextEmbedBuilder fromTextEmbed(@NotNull TextEmbed embed){
        return new TextEmbedBuilder()
            .setIconUrl(embed.getIconUrl())
            .setUrl(embed.getUrl())
            .setTitle(embed.getTitle())
            .setDescription(embed.getDescription())
            .setMedia(embed.getMedia())
            .setColour(embed.getColour());
    }
    
    /**
     * Sets the icon to display in the embed.
     * <br>The URL should link directly to an existing image.
     * 
     * @param  iconUrl
     *         URL pointing to an image.
     * 
     * @return This Builder class after the value has been set. Useful for chaining.
     */
    public TextEmbedBuilder setIconUrl(@Nullable String iconUrl){
        this.iconUrl = iconUrl;
        return this;
    }
    
    /**
     * Sets the URL used to link the title to in the TextEmbed.
     * 
     * @param  url
     *         URL to use for the title.
     *
     * @return This Builder class after the value has been set. Useful for chaining.
     */
    public TextEmbedBuilder setUrl(@Nullable String url){
        this.url = url;
        return this;
    }
    
    /**
     * Sets the title displayed in the embed.
     * 
     * @param  title
     *         The title to display in the embed.
     *
     * @return This Builder class after the value has been set. Useful for chaining.
     */
    public TextEmbedBuilder setTitle(@Nullable String title){
        this.title = title;
        return this;
    }
    
    /**
     * Sets the description to display within the embed.
     * <br>Markdown formatting is supported!
     * 
     * @param  description
     *         The text to display in the embed.
     *
     * @return This Builder class after the value has been set. Useful for chaining.
     */
    public TextEmbedBuilder setDescription(@Nullable String description){
        this.description = description;
        return this;
    }
    
    /**
     * Sets the file to use in the embed.
     * <br>The value needs to be a valid file (attachment) ID.
     * 
     * @param  media
     *         ID of the file/attachment to display in the embed.
     *
     * @return This Builder class after the value has been set. Useful for chaining.
     */
    public TextEmbedBuilder setMedia(@Nullable String media){
        this.media = media;
        return this;
    }
    
    /**
     * Sets the colour to display on the left side of the embed.
     * 
     * @param  colour
     *         The colour to set for the embed.
     *
     * @return This Builder class after the value has been set. Useful for chaining.
     */
    public TextEmbedBuilder setColour(@Nullable String colour){
        this.colour = colour;
        return this;
    }
    
    /**
     * Resets the currently set values within this TextEmbedBuilders.
     * <br>Resetting means that all values are set to {@code null}.
     *
     * @return This Builder class after all values have been reset. Useful for chaining.
     */
    public TextEmbedBuilder reset(){
        this.iconUrl = null;
        this.url = null;
        this.title = null;
        this.description = null;
        this.media = null;
        this.colour = null;
        
        return this;
    }
    
    /**
     * Builds a fresh, usable instance of a {@link ch.andre601.revolt4j.api.objects.message.TextEmbed TextEmbed}
     * that can be added to a {@link ch.andre601.revolt4j.api.objects.message.BaseMessage BaseMessage}.
     * 
     * @return Usable {@link ch.andre601.revolt4j.api.objects.message.TextEmbed TextEmbed} instance.
     * 
     * @throws java.lang.IllegalStateException
     *         When the TextEmbedBuilder is empty. This means, all values are {@link null}
     */
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
