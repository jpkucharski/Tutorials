package com.jpk.synchronization;

import java.util.Random;

public class ConsumerThread implements Runnable
{
  private Main refToMain;
    
    
    
    public ConsumerThread( Main mainObject )
    {
        this.refToMain=mainObject;
    }
    
    @Override
    public void run()
    {
   
        consumer();
   
        
    }
    public void consumer()
    {
        Random random = new Random();
        while( true )
        {
            if( random.nextInt( 10 ) == 0 )
            {
                Integer value;
                try
                {
                    value = refToMain.getQueue().take();
                    System.out.println( "Taken: " + value + "; Queue size is: " + refToMain.getQueue().size() );
                    Thread.sleep( 1000 );
                }
                catch( InterruptedException e )
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
