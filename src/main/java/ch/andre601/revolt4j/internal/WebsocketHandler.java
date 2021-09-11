package ch.andre601.revolt4j.internal;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class WebsocketHandler extends WebSocketClient{
    
    protected final Revolt4JImpl api;
    
    public WebsocketHandler(URI uri, Revolt4JImpl api){
        super(uri);
        this.api = api;
    }
    
    @Override
    public void onOpen(ServerHandshake data){
        
    }
    
    @Override
    public void onMessage(String message){
        
    }
    
    @Override
    public void onClose(int code, String reason, boolean remote){
        
    }
    
    @Override
    public void onError(Exception ex){
        
    }
}
