package ch.andre601.revolt4j.api;

import org.jetbrains.annotations.NotNull;

public interface Revolt4J{
    
    enum Status{
        STARTING,
        CONNECTING,
        LOGIN,
        CONNECTED,
        DISCONNECTED,
        CONNECT_TO_WEBSOCKET
    }
    
    /**
     * The current Gateway URL the Bot is connected to.
     * <br>By default is this https://api.revolt.chat but can be changed using the
     * {@link Revolt4JBuilder#withUrl(String) withUrl method} of the {@link Revolt4JBuilder Revolt4JBuilder}.
     * 
     * @return The currently used Gateway URL.
     */
    String getGatewayUrl();
    
    /**
     * Gives the Websocket URL that is used.
     * 
     * @return The currently used Websocket URL.
     */
    String getWebsocketUrl();
    
    /**
     * Returns the URL used for files uploaded to revolt.
     * <br>The default URL is https://autumn.revolt.chat/
     * 
     * @return URL used for files.
     */
    String getFileUrl();
    
    /**
     * Returns the URL used for the proxy.
     * <br>The default URL is https://january.revolt.chat/
     *
     * @return URL used for the proxy.
     */
    String getProxyUrl();
    
    /**
     * Returns the URL used for the Voice Chat system.
     * <br>The default URL is https://voso.revolt.chat/
     *
     * @return URL used for Voice chat.
     */
    String getVoiceUrl();
    
    /**
     * The current {@link Status Bot Status}.
     * Events will only be fired when the status is {@link Status#CONNECTED CONNECTED}.
     * 
     * @return The current Status of the bot.
     */
    Status getStatus();
    
    void setGatewayUrl(String gatewayUrl);
    
    void setStatus(Status status);
    
    void addEventListeners(@NotNull Object... listeners);
}
