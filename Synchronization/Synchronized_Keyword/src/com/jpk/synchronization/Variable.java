package com.jpk.synchronization;

public class Variable
{

    private int counter;


    public int getCounter()
    {
        return counter;
    }


    public void setCounter( int counter )
    {
        this.counter = counter;
    }


    public synchronized int inclementation( int variable )
    {
        variable++;
        return variable;
    }
}
