package com.jpk.spring1.service;

import com.jpk.spring1.service.MessageOfTheDayService;

public class MessagePrinter
{
    private MessageOfTheDayService service;
    private String separator;
    private String name;
    
    
    public MessagePrinter( String name, final String separator , final MessageOfTheDayService service )
    {
        this.service = service;
        this.separator = separator;
        this.name = name;
    }
    
    public void setService( MessageOfTheDayService service )
    {
        this.service = service;
    }
    
    public String printMessage(){
        String appendedMessage;
        final StringBuilder sb = new StringBuilder( name );
        sb.append( this.separator );
        sb.append( service.getMessage() );
        appendedMessage = sb.toString();
        return appendedMessage; 
    }
    
    
    
    
    
    
    
}
