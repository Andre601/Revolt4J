package ch.andre601.revolt4j.api.objects.message;

public class TextEmbed{
    
    public static final String EMBED_TYPE = "text";
    
    protected final String iconUrl;
    protected final String url;
    protected final String title;
    protected final String description;
    protected final String media;
    protected final String colour;
    
    public TextEmbed(String iconUrl, String url, String title, String description, String media, String colour){
        this.iconUrl = iconUrl;
        this.url = url;
        this.title = title;
        this.description = description;
        this.media = media;
        this.colour = colour;
    }
    
    public String getType(){
        return EMBED_TYPE;
    }
    
    public String getIconUrl(){
        return iconUrl;
    }
    
    public String getUrl(){
        return url;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getDescription(){
        return description;
    }
    
    public String getMedia(){
        return media;
    }
    
    public String getColour(){
        return colour;
    }
}
