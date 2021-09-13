/*
 * Copyright 2015 Austin Keener, Michael Ritter, Florian Spieß, and the JDA contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ch.andre601.revolt4j.api.utils.event;

import ch.andre601.revolt4j.api.event.BaseEvent;
import ch.andre601.revolt4j.internal.Revolt4JImpl;
import ch.andre601.revolt4j.internal.utils.logging.Revolt4JLogger;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * Event handler for Revolt4J.
 * This class is based on the InterfacedEventManager of JDA:
 * https://github.com/DV8FromTheWorld/JDA/blob/development/src/main/java/net/dv8tion/jda/api/hooks/InterfacedEventManager.java
 *
 * This class does not fall under the default MIT license!
 * Please see the LICENSE file of JDA for further details:
 * https://github.com/DV8FromTheWorld/JDA/blob/development/LICENSE
 */
public class InterfacedEventManager implements EventManager{
    
    private final CopyOnWriteArrayList<EventListener> listeners = new CopyOnWriteArrayList<>();
    
    public InterfacedEventManager(){}
    
    @Override
    public void register(@NotNull Object listener){
        if(!(listener instanceof EventListener))
            throw new IllegalArgumentException("The Listener has to implement the EventListener Interface!");
        
        listeners.add((EventListener) listener);
    }
    
    @Override
    public void unregister(@NotNull Object listener){
        if(!(listener instanceof EventListener)){
            //noinspection ConstantConditions
            Revolt4JLogger.getLogger(getClass()).warn(
                "Trying to remove a listener that does not implement EventListener: {}",
                listener == null ? "null" : listener.getClass().getName()
            );
        }
        
        //noinspection SuspiciousMethodCalls
        listeners.remove(listener);
    }
    
    @Override
    public void handle(@NotNull BaseEvent event){
        for(EventListener listener : listeners){
            try{
                listener.onEvent(event);
            }catch(Throwable throwable){
                Revolt4JImpl.LOG.error("Uncaught exception for one of the EventListeners", throwable);
                if(throwable instanceof Error)
                    throw (Error) throwable;
            }
        }
    }
    
    @Override
    @NotNull
    public List<Object> getRegisteredListeners(){
        return List.copyOf(listeners);
    }
}
