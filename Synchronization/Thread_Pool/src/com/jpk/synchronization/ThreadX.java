package com.jpk.synchronization;

public class ThreadX implements Runnable
{

    private int taskId;


    public ThreadX( int id )
    {
        this.taskId = id;
    }


    @Override
    public void run()
    {

        System.out.println( "Starting new thread, hashCode of thread: "+ this.hashCode()+" with task No.: " + taskId );
        try
        {
            Thread.sleep( 500 );
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }
        System.out.println( "Termination of thread, hashCode of thread: "+this.hashCode()+" with task No. "+ taskId );
    }

}
