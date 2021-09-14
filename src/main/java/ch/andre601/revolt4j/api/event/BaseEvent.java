package ch.andre601.revolt4j.api.event;

import ch.andre601.revolt4j.api.Revolt4J;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/**
 * The most basic event in Revold4J.
 * <br>Any other event available does inherit from this one and therefore have access to certain basic methods
 * such as {@link #getRevolt4J() getting the Revolt4J instance}.
 * 
 * <p>You can do casting to cast the BaseEvent instance into another Event IF doing the right checks first:
 * <pre><code>
 * public class MyEventListener extends InterfacedEventListener{
 *     
 *     {@literal @Override}
 *     public void onBase({@literal @NotNull} BaseEvent event){
 *         if(event instanceof ReadyEvent){
 *             ReadyEvent readyEvent = (ReadyEvent) event;
 *         }
 *     }
 * }
 * </code></pre>
 * 
 * <p>It is recommended to use more specific events over the base event to have less code to maintain and for
 * easier access to specific methods.
 */
public interface BaseEvent{
    
    @NotNull
    Revolt4J getRevolt4J();
    
    @NotNull
    JSONObject getJson();
}
