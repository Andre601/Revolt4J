package ch.andre601.revolt4j.api;

import ch.andre601.revolt4j.internal.Revolt4JImpl;
import ch.andre601.revolt4j.internal.utils.AuthConfig;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Revolt4JBuilder{
    
    protected String token = null;
    protected String url = "https://api.revolt.chat";
    
    protected final List<Object> listeners = new LinkedList<>();
    
    private Revolt4JBuilder(String token){
        this.token = token;
    }
    
    public static Revolt4JBuilder create(String token){
        return new Revolt4JBuilder(token);
    }
    
    /**
     * Set a different URL for the Revolt API.<br>
     * This should only be used when your bot should run on a self-hosted version of Revolt.
     * 
     * <p>Default is https://api.revolt.chat
     * 
     * @param  url
     *         The URL to connect to for the API.
     *         
     * @return This Builder after the URL was set. Useful for chaining.
     */
    public Revolt4JBuilder withUrl(String url){
        this.url = url;
        return this;
    }
    
    /**
     * Adds the provided Listener classes to the final {@link Revolt4J Revolt4J Object}.<br>
     * Please make sure that all objects are extending the TBN class to work.
     * 
     * @param  listeners
     *         Array of Objects to add as listeners.
     *         
     * @return This Builder after the listeners have been added. Useful for chaining.
     */
    public Revolt4JBuilder addEventListeners(@NotNull Object... listeners){
        Collections.addAll(this.listeners, listeners);
        return this;
    }
    
    /**
     * Builds a {@link Revolt4J Revolt4J instance} and starts the login process.
     * 
     * @return The Build instance of the Revolt4J interface.
     * 
     * @throws LoginException
     *         When the token is invalid.
     */
    public Revolt4J build() throws LoginException{
        Revolt4JImpl revolt4J = new Revolt4JImpl(new AuthConfig(token));
        listeners.forEach(revolt4J::addEventListeners);
        
        revolt4J.login();
        return revolt4J;
    }
}
