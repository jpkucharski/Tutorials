package com.jpk.spring1.service;

public class BasicMessageOfTheDayImpl
    implements MessageOfTheDayService

{
    private String message = "Message without injection";
    
    public String getMessage()
    {
        return message;
    }

    public void setMessage( String message )
    {
        this.message = message;
    }
}
