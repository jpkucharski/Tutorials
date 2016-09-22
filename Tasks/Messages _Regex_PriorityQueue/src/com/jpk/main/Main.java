package com.jpk.main;

import com.jpk.exceptions.InvalidMessageException;
import com.jpk.interfaces.MessageReceiver;
import com.jpk.processing.InstructionMessage;
import com.jpk.processing.InstructionQueue;
import com.jpk.processing.MessageValidationClass;


public class Main
    implements MessageReceiver
{
    private final String ERROR_MESSAGE_TEXT = "THIS_MESSAGE_IS_NOT_VALID!";

    InstructionQueue iQ = new InstructionQueue();
    MessageValidationClass mVc = new MessageValidationClass();


    @Override
    public void receive( String message ) throws InvalidMessageException
    {
        InstructionMessage recivedMessage = new InstructionMessage( message );

        if( mVc.validation( recivedMessage ) )
        {
            iQ.enqueue( recivedMessage );
        }
        else
        {
            throw new InvalidMessageException( ERROR_MESSAGE_TEXT );
        }

    }

}
