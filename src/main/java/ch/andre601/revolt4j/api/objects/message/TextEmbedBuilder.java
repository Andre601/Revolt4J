package ch.andre601.revolt4j.api.objects.message;

import ch.andre601.revolt4j.internal.objects.ObjectBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Builder class used to create an instance of a {@link ch.andre601.revolt4j.api.objects.message.TextEmbed TextEmbed}.
 * <br>TextEmbeds are <b>read only</b> by the API, so this class is required to build a new instance to send.
 * 
 * <p>A {@link #fromTextEmbed(TextEmbed) fromTextEmbed(TextEmbed)} method exists for your convenience, to create a new
 * TextEmbedBuilder instance from an already existing TextEmbed.
 */
public class TextEmbedBuilder{
    
    public static final String ZERO_WIDTH_SPACE = "\u200E";
    
    public static final String TEXT_EMBED_TYPE = "text";
    
    private String iconUrl = null;
    private String url = null;
    private String title = null;
    private String description = null;
    private String media = null;
    private String colour = null;
    
    /**
     * Creates a new, blank TextEmbedBuilder to use for creating new {@link ch.andre601.revolt4j.api.objects.message.TextEmbed TextEmbeds}.
     * 
     * <p>{@link #build() Building} this Builder instance without setting any values will result in a completely
     * blank TextEmbed.
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
     * <br>The value needs to be a valid file/attachment ID.
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
     * <p>The embed colour can be <b>any valid CSS value</b> available. Some examples:
     * <ul>
     *     <li>{@code #rrggbb} - HEX value</li>
     *     <li>{@code #rrggbbaa} - HEX value (With alpha)</li>
     *     <li>{@code rgb(r,g,b)} - RGB value</li>
     *     <li>{@code rgba(r,g,b,a)} - RGBA value</li>
     *     <li>{@code hsa(h,s,a)} - HSA value</li>
     *     <li>{@code red} - pre-defined colour name (<a href="https://www.htmlcsscolor.com/html-color-names" target="_blank">List</a>)</li>
     * </ul>
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
     */
    public TextEmbed build(){
        return ObjectBuilder.createTextEmbed(iconUrl, url, title, description, media, colour);
    }
}
