package com.jpk.processing;

import java.util.Comparator;
import java.util.PriorityQueue;


public class InstructionQueue
{

    PriorityQueue<InstructionMessage> instructionMessagesQueue;
    Comparator<InstructionMessage> comparator;


    public void enqueue( InstructionMessage message )
    {
        if( instructionMessagesQueue == null )
        {
            comparator = new PriorityComparator();
            instructionMessagesQueue = new PriorityQueue<InstructionMessage>( comparator );
            instructionMessagesQueue.add( message );
        }
        else
        {
            instructionMessagesQueue.add( message );
        }
    }


    public InstructionMessage dequeue()
    {
        return instructionMessagesQueue.remove();
    }


    public InstructionMessage peek()
    {
        return instructionMessagesQueue.element();
    }


    public int count()
    {
        return instructionMessagesQueue.size();

    }


    public boolean isEmpty()
    {
        boolean isEmpty;
        if( instructionMessagesQueue.size() != 0 )
        {
            isEmpty = false;
        }
        else
        {
            isEmpty = true;
        }
        return isEmpty;

    }

}
