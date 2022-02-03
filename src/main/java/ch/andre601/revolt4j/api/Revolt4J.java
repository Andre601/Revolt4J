package ch.andre601.revolt4j.api;

import org.jetbrains.annotations.NotNull;

/**
 * The main Revolt4J interface containg most if not all required features.
 */
public interface Revolt4J{
    
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
     * <br>The Websocket URL is retrieved when connecting to the {@link #getGatewayUrl() API} for the first time.
     * 
     * @return The currently used Websocket URL.
     */
    String getWebsocketUrl();
    
    /**
     * The URL used to display files.
     * 
     * <p>The URL is retrieved when connecting to the RevoltAPI for the first time and is https://autumn.revolt.chat
     * for the default Revolt App.
     * 
     * @return URL used for files.
     */
    String getFileUrl();
    
    /**
     * The URL used for the Proxy.
     *
     * <p>The URL is retrieved when connecting to the RevoltAPI for the first time and is https://january.revolt.chat
     * for the default Revolt App.
     *
     * @return URL used for the proxy.
     */
    String getProxyUrl();
    
    /**
     * The URL used for the legacy Voice Chat system.
     *
     * <p>The URL is retrieved when connecting to the RevoltAPI for the first time and is https://voso.revolt.chat
     * for the default Revolt App.
     *
     * @return URL used for Voice chat.
     */
    String getVoiceUrl();
    
    /**
     * The current {@link Status Bot Status}.
     * <br>Certain actions such as retrieving Events may only work while the bot has a specific Status.
     * 
     * @return The current Status of the bot.
     */
    Status getStatus();
    
    void setGatewayUrl(String gatewayUrl);
    
    void setStatus(Status status);
    
    /**
     * Adds Classes as event listeners to the bot.
     * <br>Those classes may be used whenever specific events are retrieved and allow you to handle specific situations.
     * 
     * <p><b>Provided objects need to implement the {@link ch.andre601.revolt4j.api.event.BaseEvent BaseEvent interface}!</b>
     * <br>The easiest way to do this is by extending them with the {@link ch.andre601.revolt4j.api.utils.event.InterfacedEventListener InterfacedEventListener}.
     * 
     * @param listeners
     *        Array of objects to add as Event listeners.
     */
    void addEventListeners(@NotNull Object... listeners);
    
    enum Status{
        /**
         * The Bot is starting up.
         */
        STARTING,
        /**
         * The bot connects to the Revolt API.
         */
        CONNECTING,
        /**
         * The bot is authenticating itself.
         */
        LOGIN,
        /**
         * The bot successfully established a connection and now retrieves Events.
         */
        CONNECTED,
        /**
         * The bot is disconnected from the websocket and may try to reconnect.
         */
        DISCONNECTED,
        /**
         * The bot connects to the websocket.
         */
        CONNECT_TO_WEBSOCKET
    }
}
