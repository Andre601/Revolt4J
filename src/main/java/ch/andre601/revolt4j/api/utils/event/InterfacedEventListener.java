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
import ch.andre601.revolt4j.internal.utils.ClassWalker;
import org.jetbrains.annotations.NotNull;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * An abstract class containing pre-made event methods for you to use.
 * <br>You need to <b>override</b> the methods you want to use in order for it to work.
 * 
 * <h2>Example</h2>
 * <pre><code>
 * public class MyEventListeners extends InterfacedEventListener{
 *     
 *     {@literal @Override}
 *     public void onBase({@literal @NotNull BaseEvent event}){
 *         System.out.prntln("Received event!");
 *     }
 * }
 * </code></pre>
 * 
 * <h2>Copyright notice</h2>
 * This class is originally from JDA's ListenerAdabter:
 * <br>https://github.com/DV8FromTheWorld/JDA/blob/development/src/main/java/net/dv8tion/jda/api/hooks/ListenerAdapter.java
 * 
 * It does NOT fall under the default MIT license of this project and is under a completely separate License.
 * <br>Please see the LICENSE file of JDA for more details:
 * <br>https://github.com/DV8FromTheWorld/JDA/blob/development/LICENSE
 */
public abstract class InterfacedEventListener implements EventListener{
    
    private static final MethodHandles.Lookup lookup = MethodHandles.lookup();
    private static final ConcurrentHashMap<Class<?>, MethodHandle> methods = new ConcurrentHashMap<>(); 
    private static final Set<Class<?>> unresolved;
    
    static{
        unresolved = ConcurrentHashMap.newKeySet();
        Collections.addAll(
            unresolved,
            Object.class,
            BaseEvent.class
        );
    }
    
    public void onBase(@NotNull BaseEvent event){}
    
    @Override
    public final void onEvent(@NotNull BaseEvent event){
        onBase(event);
        
        for(Class<?> clazz : ClassWalker.range(event.getClass(), BaseEvent.class)){
            if(unresolved.contains(clazz))
                continue;
            
            MethodHandle methodHandle = methods.computeIfAbsent(clazz, InterfacedEventListener::findMethod);
            if(methodHandle == null){
                unresolved.add(clazz);
                continue;
            }
            
            try{
                methodHandle.invoke(this, event);
            }catch(Throwable throwable){
                if(throwable instanceof RuntimeException)
                    throw (RuntimeException) throwable;
                
                if(throwable instanceof Error)
                    throw (Error) throwable;
                
                throw new IllegalStateException(throwable);
            }
        }
    }
    
    private static MethodHandle findMethod(Class<?> clazz){
        String name = clazz.getSimpleName();
        MethodType type = MethodType.methodType(Void.TYPE, clazz);
        try{
            name = "on" + name.substring(0, name.length() - "Event".length());
            return lookup.findVirtual(InterfacedEventListener.class, name, type);
        }catch(NoSuchMethodException | IllegalAccessException ignored){}
        
        return null;
    }
}
