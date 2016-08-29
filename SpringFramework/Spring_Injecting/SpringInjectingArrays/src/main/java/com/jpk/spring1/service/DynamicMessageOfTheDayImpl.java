package com.jpk.spring1.service;

import java.util.*;

import com.jpk.spring1.model.MessageValue;
import com.jpk.spring1.service.MessageOfTheDayService;


public class DynamicMessageOfTheDayImpl implements MessageOfTheDayService
{
    private String[] messages;
    
    private String[] messageArray={};
    private MessageValue[] messageValueArray = {};
    
    private List<String> messageList = new ArrayList<>();
    private List<MessageValue> messageValueList = new ArrayList<MessageValue>();
    
    private Map<Integer, String> messageMap = new HashMap<Integer, String>();
    private Map<Integer, MessageValue > messageValueMap = new HashMap<Integer, MessageValue>();

    public String getMessage()
    {
        final int day = GregorianCalendar.getInstance().get(  Calendar.DAY_OF_WEEK );
        String message ="";
        if(messageArray.length>0){
            message = "From Array: "+ messageArray[day-1];
        }
        if(messageValueArray.length>0){
            message = "From Array Constructor injection: "+ messageValueArray[day-1].getMessage();
        }
        if(!messageList.isEmpty()){
            message = "From List: " + messageList.get( day-1 );
        }
        if(!messageValueList.isEmpty()){
            message = "From List by object: " + messageValueList.get( day-1 );
        }
        if(!messageMap.isEmpty()){
            message = "From Map: "+ messageMap.get( day );
        }
        if(!messageValueMap.isEmpty()){
            message = "From Map MessageValue object: "+ messageValueMap.get( day ).getMessage();
        }
        return message;
    }


    public void setMessages( String[] messages )
    {
        this.messages = (String[])messages.clone();
    }
    
    public void setMessagesArray (final String[] messageArray){
        this.messageArray=(String[])messageArray.clone();
    }

    public void setMessageValueArray( MessageValue[] messageValueArray )
    {
        this.messageValueArray = messageValueArray;
    }

    public void setMessageList(final List<String> messageList){
        this.messageList.addAll( messageList );
    }
    
    public void setMessageValueList(final List<MessageValue> messageValueList){
        this.messageValueList.addAll( messageValueList );
    }
    
    public void setMessageMap(final Map<Integer, String> messageMap){
        this.messageMap.putAll(messageMap);
    }
    
    public void setMessageValueMap(final Map<Integer, MessageValue> messageValueMap){
        this.messageValueMap.putAll( messageValueMap );
    }
    
}
