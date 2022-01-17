package ch.andre601.revolt4j.internal;

import ch.andre601.revolt4j.api.Revolt4J;
import ch.andre601.revolt4j.api.utils.event.InterfacedEventManager;
import ch.andre601.revolt4j.internal.utils.AuthConfig;
import ch.andre601.revolt4j.internal.utils.event.EventManagerProxy;
import ch.andre601.revolt4j.internal.utils.logging.Revolt4JLogger;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import javax.security.auth.login.LoginException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class Revolt4JImpl implements Revolt4J{
    
    public static final Logger LOG = Revolt4JLogger.getLogger(Revolt4J.class);
    
    protected Status status = Status.STARTING;
    
    protected String gatewayUrl = "https://api.revolt.chat";
    protected String websocketUrl = null;
    protected String fileUrl = null;
    protected String proxyUrl = null;
    protected String voiceUrl = null;
    protected List<Object> listeners = new ArrayList<>();
    
    protected final AuthConfig authConfig;
    protected WebsocketHandler handler;
    protected final EventManagerProxy eventManager;
    
    public Revolt4JImpl(AuthConfig authConfig){
        this.authConfig = authConfig;
        this.eventManager = new EventManagerProxy(new InterfacedEventManager(), Executors.newSingleThreadScheduledExecutor());
    }
    
    @Override
    public Status getStatus(){
        return status;
    }
    
    @Override
    public String getGatewayUrl(){
        return gatewayUrl;
    }
    
    @Override
    public String getWebsocketUrl(){
        return websocketUrl;
    }
    
    @Override
    public String getFileUrl(){
        return fileUrl;
    }
    
    @Override
    public String getProxyUrl(){
        return proxyUrl;
    }
    
    @Override
    public String getVoiceUrl(){
        return voiceUrl;
    }
    
    @Override
    public void setStatus(Status status){
        this.status = status;
    }
    
    @Override
    public void setGatewayUrl(String gatewayUrl){
        this.gatewayUrl = gatewayUrl;
    }
    
    @Override
    public void addEventListeners(@NotNull Object... listeners){
        for(Object listener : listeners)
            eventManager.register(listener);
    }
    
    public Revolt4JImpl setWebsocketUrl(String websocketUrl){
        this.websocketUrl = websocketUrl;
        return this;
    }
    
    public Revolt4JImpl setFileUrl(String fileUrl){
        this.fileUrl = fileUrl;
        return this;
    }
    
    public Revolt4JImpl setProxyUrl(String url){
        this.proxyUrl = proxyUrl;
        return this;
    }
    
    public Revolt4JImpl setVoiceUrl(String voiceUrl){
        this.voiceUrl = voiceUrl;
        return this;
    }
    
    public int login() throws LoginException{
        String token = authConfig.getToken();
        URI gatewayUrl;
        
        try{
            gatewayUrl = new URI(getGatewayUrl());
        }catch(URISyntaxException ex){
            throw new LoginException("Malformed or invalid Gateway URL " + getGatewayUrl());
        }
        
        setStatus(Status.LOGIN);
        
        if(token == null || token.isEmpty())
            throw new LoginException("The provided token was invalid!");
        
        handler = new WebsocketHandler(gatewayUrl, this);
        
        return 1;
    }
}
