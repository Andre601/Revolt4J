package ch.andre601.revolt4j.api.objects;

import ch.andre601.revolt4j.api.Revolt4J;

import java.util.List;

public interface User{
    
    String getId();
    
    String getName();
    
    class Avatar{
        private final Revolt4J api;
        
        private final String id;
        private final String name;
        private final String contentType;
        
        public Avatar(Revolt4J api, String id, String name, String contentType){
            this.api = api;
            
            this.id = id;
            this.name = name;
            this.contentType = contentType;
        }
    
        public String getId(){
            return id;
        }
    
        public String getName(){
            return name;
        }
    
        public String getContentType(){
            return contentType;
        }
    
        public String getUrl(){
            return api.getFileUrl() + getId() + "/" + getName() + "." + getContentType();
        }
    }
}
