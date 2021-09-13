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

import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.helpers.Util;
import org.slf4j.spi.LocationAwareLogger;

import java.io.*;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

/*
 * The SimpleLogger class taken over from JDA:
 * https://github.com/DV8FromTheWorld/JDA/blob/development/src/main/java/net/dv8tion/jda/internal/utils/SimpleLogger.java
 * 
 * This class does not fall under the default MIT license!
 * Please see the LICENSE file of JDA for further details:
 * https://github.com/DV8FromTheWorld/JDA/blob/development/LICENSE
 */
public class SimpleLogger extends MarkerIgnoringBase{
    
    private static final long serialVersionUID = -8862715489224852145L;
    private static final String CONFIGURATION_FILE = "Loggerger.properties";
    
    private static final long START_TIME = System.currentTimeMillis();
    private static final Properties SIMPLE_LOGGER_PROPS = new Properties();
    
    private static final int LOG_LEVEL_TRACE = LocationAwareLogger.TRACE_INT;
    private static final int LOG_LEVEL_DEBUG = LocationAwareLogger.DEBUG_INT;
    private static final int LOG_LEVEL_INFO = LocationAwareLogger.INFO_INT;
    private static final int LOG_LEVEL_WARN = LocationAwareLogger.WARN_INT;
    private static final int LOG_LEVEL_ERROR = LocationAwareLogger.ERROR_INT;
    
    private static boolean INITIALIZED = false;
    
    private static int DEFAULT_LOG_LEVEL = LOG_LEVEL_INFO;
    private static boolean SHOW_DATE_TIME = false;
    private static String DATE_TIME_FORMAT_STR = null;
    private static DateFormat DATE_FORMATTER = null;
    private static boolean SHOW_THREAD_NAME = true;
    private static boolean SHOW_LOG_NAME = true;
    private static boolean SHOW_SHORT_LOG_NAME = false;
    private static String LOG_FILE = "System.err";
    private static PrintStream TARGET_STREAM = null;
    private static boolean LEVEL_IN_BRACKETS = false;
    private static String WARN_LEVEL_STRING = "WARN";
    
    public static final String SYSTEM_PREFIX = "org.slf4j.Loggerger.";
    
    public static final String DEFAULT_LOG_LEVEL_KEY = SYSTEM_PREFIX + "defaultLogLevel";
    public static final String SHOW_DATE_TIME_KEY = SYSTEM_PREFIX + "showDateTime";
    public static final String DATE_TIME_FORMAT_KEY = SYSTEM_PREFIX + "dateTimeFormat";
    public static final String SHOW_THREAD_NAME_KEY = SYSTEM_PREFIX + "showThreadName";
    public static final String SHOW_LOG_NAME_KEY = SYSTEM_PREFIX + "showLogName";
    public static final String SHOW_SHORT_LOG_NAME_KEY = SYSTEM_PREFIX + "showShortLogName";
    public static final String LOG_FILE_KEY = SYSTEM_PREFIX + "logFile";
    public static final String LEVEL_IN_BRACKETS_KEY = SYSTEM_PREFIX + "levelInBrackets";
    public static final String WARN_LEVEL_STRING_KEY = SYSTEM_PREFIX + "warnLevelString";
    
    public static final String LOG_KEY_PREFIX = SYSTEM_PREFIX + "log.";
    
    protected int currentLogLevel;
    private transient String shortLogName = null;
    
    SimpleLogger(String name){
        if(!INITIALIZED)
            init();
        
        this.name = name;
        
        String level = recursivelyComputeLevel();
        if(level != null)
            this.currentLogLevel = stringToLevel(level);
        else
            this.currentLogLevel = DEFAULT_LOG_LEVEL;
    }
    
    static void init(){
        INITIALIZED = true;
        loadProperties();
        
        String defaultLogLevel = getStringProperty(DEFAULT_LOG_LEVEL_KEY, null);
        if(defaultLogLevel != null)
            DEFAULT_LOG_LEVEL = stringToLevel(defaultLogLevel);
        
        SHOW_LOG_NAME = getBooleanProperty(SHOW_LOG_NAME_KEY, SHOW_LOG_NAME);
        SHOW_SHORT_LOG_NAME = getBooleanProperty(SHOW_SHORT_LOG_NAME_KEY, SHOW_SHORT_LOG_NAME);
        SHOW_DATE_TIME = getBooleanProperty(SHOW_DATE_TIME_KEY, SHOW_DATE_TIME);
        SHOW_THREAD_NAME = getBooleanProperty(SHOW_THREAD_NAME_KEY, SHOW_THREAD_NAME);
        DATE_TIME_FORMAT_STR = getStringProperty(DATE_TIME_FORMAT_KEY, DATE_TIME_FORMAT_STR);
        LEVEL_IN_BRACKETS = getBooleanProperty(LEVEL_IN_BRACKETS_KEY, LEVEL_IN_BRACKETS);
        WARN_LEVEL_STRING = getStringProperty(WARN_LEVEL_STRING_KEY, WARN_LEVEL_STRING);
        
        LOG_FILE = getStringProperty(LOG_FILE_KEY, LOG_FILE);
        TARGET_STREAM = computeStream(LOG_FILE);
        
        if(DATE_TIME_FORMAT_STR != null){
            try{
                DATE_FORMATTER = new SimpleDateFormat(DATE_TIME_FORMAT_STR);
            }catch(IllegalArgumentException ex){
                Util.report("Bad date format provided in " + CONFIGURATION_FILE + ". Will output relative time instead!", ex);
            }
        }
    }
    
    private static void loadProperties(){
        InputStream is = AccessController.doPrivileged((PrivilegedAction<InputStream>)() -> {
            ClassLoader threadClassLoader = Thread.currentThread().getContextClassLoader();
            if(threadClassLoader != null){
                return threadClassLoader.getResourceAsStream(CONFIGURATION_FILE);
            }else{
                return ClassLoader.getSystemResourceAsStream(CONFIGURATION_FILE);
            }
        });
        
        if(null != is){
            try{
                SIMPLE_LOGGER_PROPS.load(is);
                is.close();
            }catch(IOException ignored){}
        }
    }
    
    private static String getStringProperty(String name){
        String property;
        try{
            property = System.getProperty(name);
        }catch(SecurityException ignored){
            property = null;
        }
        
        return (property == null) ? SIMPLE_LOGGER_PROPS.getProperty(name) : property;
    }
    
    private static String getStringProperty(String name, String def){
        String property = getStringProperty(name);
        return (property == null) ? def : property;
    }
    
    private static boolean getBooleanProperty(String name, boolean def){
        String property = getStringProperty(name);
        return (property == null) ? def : "true".equalsIgnoreCase(property);
    }
    
    private static int stringToLevel(String level){
        switch(level.toLowerCase(Locale.ROOT)){
            case "trace":
                return LOG_LEVEL_TRACE;
            
            case "debug":
                return LOG_LEVEL_DEBUG;
            
            case "info":
            default:
                return LOG_LEVEL_INFO;
            
            case "warn":
                return LOG_LEVEL_WARN;
            
            case "error":
                return LOG_LEVEL_ERROR;
        }
    }
    
    private static PrintStream computeStream(String logFile){
        if("System.err".equalsIgnoreCase(logFile)){
            return System.err;
        }else if("System.out".equalsIgnoreCase(logFile)){
            return System.out;
        }else{
            try{
                FileOutputStream fos = new FileOutputStream(logFile);
                
                return new PrintStream(fos);
            }catch(FileNotFoundException ex){
                Util.report("Cannot find file '" + logFile + "'- Defaulting to System.err", ex);
                return System.err;
            }
        }
    }
    
    String recursivelyComputeLevel(){
        String temp = name;
        String level = null;
        int lastDotIndex = temp.length();
        
        while((level == null) && (lastDotIndex > -1)){
            temp = temp.substring(0, lastDotIndex);
            level = getStringProperty(LOG_KEY_PREFIX + temp, null);
            lastDotIndex = temp.lastIndexOf(".");
        }
        
        return level;
    }
    
    private void log(int level, String message, Throwable throwable){
        if(!isLevelEnabled(level))
            return;
        
        StringBuilder builder = new StringBuilder(32);
        
        if(SHOW_DATE_TIME){
            if(DATE_FORMATTER != null){
                builder.append(getFormattedDate());
            }else{
                builder.append(System.currentTimeMillis() - START_TIME);
            }
            
            builder.append(' ');
        }
        
        if(SHOW_THREAD_NAME){
            builder.append("[")
                .append(Thread.currentThread().getName())
                .append("] ");
        }
        
        if(LEVEL_IN_BRACKETS)
            builder.append("[");
        
        switch(level){
            case LOG_LEVEL_TRACE:
                builder.append("TRACE");
                break;
            
            case LOG_LEVEL_DEBUG:
                builder.append("DEBUG");
                break;
            
            case LOG_LEVEL_INFO:
                builder.append("INFO");
                break;
            
            case LOG_LEVEL_WARN:
                builder.append(WARN_LEVEL_STRING);
                break;
            
            case LOG_LEVEL_ERROR:
                builder.append("ERROR");
                break;
        }
        
        if(LEVEL_IN_BRACKETS)
            builder.append("]");
        
        builder.append(' ');
        
        if(SHOW_SHORT_LOG_NAME){
            if(shortLogName == null)
                shortLogName = computeShortName();
            
            builder.append(shortLogName);
        }else
        if(SHOW_LOG_NAME){
            builder.append(name);
        }
        
        builder.append(" - ");
        
        builder.append(message);
        
        write(builder, throwable);
    }
    
    protected boolean isLevelEnabled(int level){
        return (level >= currentLogLevel);
    }
    
    private String getFormattedDate(){
        Date now = new Date();
        String dateText;
        
        synchronized(DATE_FORMATTER){
            dateText = DATE_FORMATTER.format(now);
        }
        
        return dateText;
    }
    
    private String computeShortName(){
        return name.substring(name.lastIndexOf(".") + 1);
    }
    
    void write(StringBuilder builder, Throwable throwable){
        TARGET_STREAM.println(builder.toString());
        if(throwable != null)
            throwable.printStackTrace(TARGET_STREAM);
        
        TARGET_STREAM.flush();
    }
    
    private void logFormatted(int level, String format, Object arg1, Object arg2){
        if(!isLevelEnabled(level))
            return;
    
        FormattingTuple tuple = MessageFormatter.format(format, arg1, arg2);
        log(level, tuple.getMessage(), tuple.getThrowable());
    }
    
    private void logFormatted(int level, String format, Object... args){
        if(!isLevelEnabled(level))
            return;
    
        FormattingTuple tuple = MessageFormatter.format(format, args);
        log(level, tuple.getMessage(), tuple.getThrowable());
    }
    
    @Override
    public boolean isTraceEnabled(){
        return isLevelEnabled(LOG_LEVEL_TRACE);
    }
    
    @Override
    public void trace(String msg){
        log(LOG_LEVEL_TRACE, msg, null);
    }
    
    @Override
    public void trace(String format, Object arg){
        logFormatted(LOG_LEVEL_TRACE, format, arg, null);
    }
    
    @Override
    public void trace(String format, Object arg1, Object arg2){
        logFormatted(LOG_LEVEL_TRACE, format, arg1, arg2);
    }
    
    @Override
    public void trace(String format, Object... arguments){
        logFormatted(LOG_LEVEL_TRACE, format, arguments);
    }
    
    @Override
    public void trace(String msg, Throwable t){
        log(LOG_LEVEL_TRACE, msg, t);
    }
    
    @Override
    public boolean isDebugEnabled(){
        return isLevelEnabled(LOG_LEVEL_DEBUG);
    }
    
    @Override
    public void debug(String msg){
        log(LOG_LEVEL_DEBUG, msg, null);
    }
    
    @Override
    public void debug(String format, Object arg){
        logFormatted(LOG_LEVEL_DEBUG, format, arg, null);
    }
    
    @Override
    public void debug(String format, Object arg1, Object arg2){
        logFormatted(LOG_LEVEL_DEBUG, format, arg1, arg2);
    }
    
    @Override
    public void debug(String format, Object... arguments){
        logFormatted(LOG_LEVEL_DEBUG, format, arguments);
    }
    
    @Override
    public void debug(String msg, Throwable t){
        log(LOG_LEVEL_DEBUG, msg, t);
    }
    
    @Override
    public boolean isInfoEnabled(){
        return isLevelEnabled(LOG_LEVEL_INFO);
    }
    
    @Override
    public void info(String msg){
        log(LOG_LEVEL_INFO, msg, null);
    }
    
    @Override
    public void info(String format, Object arg){
        logFormatted(LOG_LEVEL_INFO, format, arg, null);
    }
    
    @Override
    public void info(String format, Object arg1, Object arg2){
        logFormatted(LOG_LEVEL_INFO, format, arg1, arg2);
    }
    
    @Override
    public void info(String format, Object... arguments){
        logFormatted(LOG_LEVEL_INFO, format, arguments);
    }
    
    @Override
    public void info(String msg, Throwable t){
        log(LOG_LEVEL_INFO, msg, t);
    }
    
    @Override
    public boolean isWarnEnabled(){
        return isLevelEnabled(LOG_LEVEL_WARN);
    }
    
    @Override
    public void warn(String msg){
        log(LOG_LEVEL_WARN, msg, null);
    }
    
    @Override
    public void warn(String format, Object arg){
        logFormatted(LOG_LEVEL_WARN, format, arg, null);
    }
    
    @Override
    public void warn(String format, Object arg1, Object arg2){
        logFormatted(LOG_LEVEL_WARN, format, arg1, arg2);
    }
    
    @Override
    public void warn(String format, Object... arguments){
        logFormatted(LOG_LEVEL_WARN, format, arguments);
    }
    
    @Override
    public void warn(String msg, Throwable t){
        log(LOG_LEVEL_WARN, msg, t);
    }
    
    @Override
    public boolean isErrorEnabled(){
        return isLevelEnabled(LOG_LEVEL_ERROR);
    }
    
    @Override
    public void error(String msg){
        log(LOG_LEVEL_ERROR, msg, null);
    }
    
    @Override
    public void error(String format, Object arg){
        logFormatted(LOG_LEVEL_ERROR, format, arg, null);
    }
    
    @Override
    public void error(String format, Object arg1, Object arg2){
        logFormatted(LOG_LEVEL_ERROR, format, arg1, arg2);
    }
    
    @Override
    public void error(String format, Object... arguments){
        logFormatted(LOG_LEVEL_ERROR, format, arguments);
    }
    
    @Override
    public void error(String msg, Throwable t){
        log(LOG_LEVEL_ERROR, msg, t);
    }
}