package ch.andre601.revolt4j.internal.utils;

import org.json.JSONObject;

public class JSONHelper{
    
    private JSONHelper(){}
    
    public static JSONObject getJSON(RequestType type){
        return new JSONObject().put("type", type.getType());
    }
    
    public enum RequestType{
        AUTHENTICATE("Authenticate"),
        BEGIN_TYPING("BeginTyping"),
        END_TYPING("EndTyping"),
        PING("Ping");
        
        private final String type;
        
        RequestType(String type){
            this.type = type;
        }
        
        public String getType(){
            return type;
        }
    }
}
