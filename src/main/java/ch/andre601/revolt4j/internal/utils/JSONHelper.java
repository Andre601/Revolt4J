package ch.andre601.revolt4j.internal.utils;

import org.json.JSONObject;

public enum JSONHelper{
    AUTHENTICATE("Authenticate"),
    BEGIN_TYPING("BeginTyping"),
    END_TYPING("EndTyping"),
    PING("Ping");
    
    private final String type;
    
    JSONHelper(String type){
        this.type = type;
    }
    
    public JSONObject getAsJSON(){
        return new JSONObject().put("type", getType());
    }
    
    private String getType(){
        return type;
    }
}
