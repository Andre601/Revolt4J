package ch.andre601.revolt4j.internal;

import ch.andre601.revolt4j.internal.utils.JSONHelper;
import ch.andre601.revolt4j.internal.utils.logging.Revolt4JLogger;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONObject;
import org.slf4j.Logger;

import java.net.URI;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WebsocketHandler extends WebSocketClient{
    
    protected final Revolt4JImpl api;
    
    private final Logger LOG = Revolt4JLogger.getLogger(WebsocketHandler.class);
    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    private long lastTimestamp = 0;
    private boolean shutdown = false;
    
    public WebsocketHandler(URI uri, Revolt4JImpl api){
        super(uri);
        this.api = api;
    }
    
    public void setShutdown(boolean shutdown){
        this.shutdown = shutdown;
    }
    
    @Override
    public void onOpen(ServerHandshake data){
        
        executor.scheduleAtFixedRate(() -> {
            this.lastTimestamp = System.currentTimeMillis();
            JSONObject pingJson = JSONHelper.PING.getAsJSON().put("time", lastTimestamp);
            
            this.send(pingJson.toString());
        }, 10, 10, TimeUnit.SECONDS);
    }
    
    @Override
    public void onMessage(String message){
        JSONObject json = new JSONObject(message);
        
        String type = json.getString("type");
        if(type.equalsIgnoreCase("pong")){
            long time = json.optLong("data");
            
            if(time == 0 || time > lastTimestamp){
                LOG.warn("Missed a Heartbeat from the Revolt Server! Is the connection lagging?");
            }else{
                LOG.debug("Received Pong response.");
                this.lastTimestamp = time;
            }
        }
    }
    
    @Override
    public void onClose(int code, String reason, boolean remote){
        if(!shutdown)
            LOG.warn("Connection has been closed by the Revolt Server without Revolt4J initiating a shutdown! Is the server offline?");
    }
    
    @Override
    public void onError(Exception ex){
        
    }
}
