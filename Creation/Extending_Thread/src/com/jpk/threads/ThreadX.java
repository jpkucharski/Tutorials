package com.jpk.threads;

public class ThreadX
    extends Thread
{

    private String id;


    public ThreadX( String id )
    {
        this.id = id;
    }


    public void run()
    {
        threadStatus();
    }


    private void threadStatus()
    {
        System.out.println( "Starting thread No. " + id );
        try
        {
            Thread.sleep( 1000 );
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }
        System.out.println( "Ending Thread No. " + id );
    }
}
