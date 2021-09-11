package ch.andre601.revolt4j.internal.utils;

import org.jetbrains.annotations.NotNull;

public final class AuthConfig{
    
    private String token;
    
    public AuthConfig(@NotNull String token){
        setToken(token);
    }
    
    public String getToken(){
        return token;
    }
    
    public void setToken(String token){
        this.token = token;
    }
}
