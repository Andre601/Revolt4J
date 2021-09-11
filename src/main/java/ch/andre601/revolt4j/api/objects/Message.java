package ch.andre601.revolt4j.api.objects;

public class Message{
    String id;
    protected final Type messageType;
    
    public Message(String id, Type messageType){
        this.id = id;
        this.messageType = messageType;
    }
    
    public Type getMessageType(){
        return messageType;
    }
    
    enum Type{
        SERVER,
        GROUP,
        SERVER_SYSTEM
    }
}
