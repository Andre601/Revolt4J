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

package ch.andre601.revolt4j.internal.utils.logging;

import org.apache.commons.collections4.map.CaseInsensitiveMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.ServiceLoader;

/*
 * Utility Logger class based off the JDALogger class from JDA:
 * https://github.com/DV8FromTheWorld/JDA/blob/development/src/main/java/net/dv8tion/jda/internal/utils/JDALogger.java
 *
 * This class does not fall under the default MIT license!
 * Please see the LICENSE file of JDA for further details:
 * https://github.com/DV8FromTheWorld/JDA/blob/development/LICENSE
 */
public class Revolt4JLogger{
    
    public static final boolean HAS_SLF4J;
    
    static{
        boolean temp = false;
        
        try{
            Class.forName("org.slf4j.impl.StaticLoggerBinder");
            temp = true;
        }catch(ClassNotFoundException exBinder){
            try{
                Class<?> serviceProvider = Class.forName("org.slf4j.spi.SLF4JServiceProvider");
                temp = ServiceLoader.load(serviceProvider).iterator().hasNext();
            }catch(ClassNotFoundException exProvider){
                LoggerFactory.getLogger(Revolt4JLogger.class);
            }
        }
        
        HAS_SLF4J = temp;
    }
    
    private static final Map<String, Logger> LOGGERS = new CaseInsensitiveMap<>();
    
    private Revolt4JLogger(){}
    
    public static Logger getLogger(Class<?> clazz){
        synchronized(LOGGERS){
            if(HAS_SLF4J)
                return LoggerFactory.getLogger(clazz);
            
            return LOGGERS.computeIfAbsent(clazz.getName(), (n) -> new SimpleLogger(clazz.getSimpleName()));
        }
    }
}
