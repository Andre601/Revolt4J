package ch.andre601.revolt4j.api.objects.message;

import ch.andre601.revolt4j.api.Revolt4J;
import ch.andre601.revolt4j.api.objects.properties.Snowflake;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * A basic File object.
 * <br>Every other file-based object such as Attachments or User Avatars extend this interfaces since they share
 * the same basic structure.
 */
public interface BaseFile extends Snowflake{
    
    /**
     * Gives the currently used {@link Revolt4J Revolt4J instance} associated with this BaseFile.
     * 
     * @return The currently used Revolt4J instance.
     */
    @NotNull
    Revolt4J getRevolt4J();
    
    /**
     * Gets the tag of this BaseFile object.
     * <br>The "tag" essentially tells you for what or where this file is used. As an example, a BaseFile with the
     * tag {@link Tag#ATTACHMENTS "attachments"} means that the file is an attachment of a message.
     * 
     * @return Non-null {@link Tag} representing the current tag type of the BaseFile.
     */
    @NotNull
    Tag getTag();
    
    /**
     * Gives the current size of the BaseFile in bytes.
     * 
     * @return BaseFile size in bytes.
     */
    int getSize();
    
    /**
     * Gives the name of this BaseFile.
     * <br>The name will also include the File extension (i.e. {@code .png}) of the file. To only get the file name
     * itself without any extension applied, use {@link #getFileName(boolean) getFileName(false)}.
     * 
     * @return Non-null String representing the file name with file extension.
     */
    @NotNull
    default String getFileName(){
        return getFileName(true);
    }
    
    /**
     * Gives the name of this BaseFile.
     * <br>When {@code true} is provided will the file name include the file extension (i.e. .png).
     *
     * @return Non-null String representing the file name with optional file extension.
     * 
     * @see #getFileName() String: getFileName()
     */
    @NotNull
    String getFileName(boolean withExtension);
    
    /**
     * Gives a Map containing a String-Object pair representing the metadata provided from Revolt.
     * <br>The returned metadata can be different for each BaseFile.
     * 
     * @return Map containing String-Object pairs representing various metadata.
     */
    @NotNull
    Map<String, Object> getMetadata();
    
    /**
     * Returns the actual content-type of this BaseFile.
     * 
     * @return The content-type of this BaseFile.
     */
    @NotNull
    String getContentType();
    
    enum Tag {
        ATTACHMENTS,
        AVATARS,
        BACKGROUNDS,
        BANNERS,
        ICONS,
        
        UNKNOWN;
        
        Tag(){}
        
        public static Tag getFromString(String tagName){
            for(Tag tag : values()){
                if(tag.name().equalsIgnoreCase(tagName))
                    return tag;
            }
            
            return Tag.UNKNOWN;
        }
    }
}
