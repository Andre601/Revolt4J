package ch.andre601.revolt4j.internal.utils.events;

import ch.andre601.revolt4j.api.event.BaseEvent;
import ch.andre601.revolt4j.api.utils.event.EventManager;
import ch.andre601.revolt4j.api.utils.event.InterfacedEventManager;
import ch.andre601.revolt4j.internal.Revolt4JImpl;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/*
 * Evenet Manager class adobted from JDA:
 * https://github.com/DV8FromTheWorld/JDA/blob/development/src/main/java/net/dv8tion/jda/internal/hooks/EventManagerProxy.java
 *
 * This class does not fall under the default MIT license!
 * Please see the LICENSE file of JDA for further details:
 * https://github.com/DV8FromTheWorld/JDA/blob/development/LICENSE
 */
public class EventManagerProxy implements EventManager{
    
    private EventManager subject;
    private final ExecutorService executor;
    
    public EventManagerProxy(EventManager subject, ExecutorService executor){
        this.subject = subject;
        this.executor = executor;
    }
    
    public EventManager getSubject(){
        return subject;
    }
    
    public void setSubject(EventManager subject){
        this.subject = subject == null ? new InterfacedEventManager() : subject;
    }
    
    @Override
    public void register(@NotNull Object listener){
        this.subject.register(listener);
    }
    
    @Override
    public void unregister(@NotNull Object listener){
        this.subject.unregister(listener);
    }
    
    @Override
    public void handle(@NotNull BaseEvent event){
        try{
            if(executor != null && !executor.isShutdown())
                executor.execute(() -> handle(event));
            else
                handleInternally(event);
        }catch(RejectedExecutionException exRejected){
            Revolt4JImpl.LOG.warn("The Event-Pool rejected the event execution! Running on Handler-thread instead...");
            
            handleInternally(event);
        }catch(Exception exOther){
            Revolt4JImpl.LOG.error("Encountered Exception while scheduling event.", exOther);
        }
    }
    
    private void handleInternally(@NotNull BaseEvent event){
        try{
            subject.handle(event);
        }catch(RuntimeException ex){
            Revolt4JImpl.LOG.error("Uncaught exception for the EventManager's handle() call.", ex);
        }
    }
    
    @NotNull
    @Override
    public List<Object> getRegisteredListeners(){
        return subject.getRegisteredListeners();
    }
}
