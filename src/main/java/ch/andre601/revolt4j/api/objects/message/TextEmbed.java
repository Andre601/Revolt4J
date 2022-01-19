package ch.andre601.revolt4j.api.objects.message;

import org.jetbrains.annotations.Nullable;

/**
 * Represents an instance of an embed of the type text.
 * 
 * <p>This object cannot be altered. You have to use
 * {@link ch.andre601.revolt4j.api.objects.message.TextEmbedBuilder#fromTextEmbed(TextEmbed) TextEmbedBuilder.fromTextEmbed(TextEmbed)}
 * to create a copy that can be edited.
 */
public interface TextEmbed{
    
    /**
     * The embed type.
     * 
     * @return Always {@code text} for this embed type.
     */
    @Nullable String getType();
    
    /**
     * The currently set icon URL this embed may have.
     * 
     * @return Possibly-null String representing the icon URL of the embed.
     */
    @Nullable String getIconUrl();
    
    /**
     * The currently set URL this embed may have for the title.
     *
     * @return Possibly-null String representing the URL of the embed.
     */
    @Nullable String getUrl();
    
    /**
     * The currently set title this embed may have.
     *
     * @return Possibly-null String representing the title of the embed.
     */
    @Nullable String getTitle();
    
    /**
     * The currently set description this embed may have.
     *
     * @return Possibly-null String representing the description of the embed.
     */
    @Nullable String getDescription();
    
    /**
     * The currently set media ID this embed may have.
     * <br>The ID is a unique one from a file or attachment on Revolt.
     *
     * @return Possibly-null String representing the media ID of the embed.
     */
    @Nullable String getMedia();
    
    /**
     * The currently set colour this embed may have.
     *
     * @return Possibly-null String representing the colour of the embed.
     */
    @Nullable String getColour();
    
}
