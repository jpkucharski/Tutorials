package com.jpk.synchronization;

public class CustomerThread extends Thread
{

    private int ticketsNeeded;
    
    
    public CustomerThread( int quantity, Runnable target, String name )
    {
        super( target, name );
        this.ticketsNeeded=quantity;
    }


    public int getTicketsNeeded()
    {
        return ticketsNeeded;
    }
}
