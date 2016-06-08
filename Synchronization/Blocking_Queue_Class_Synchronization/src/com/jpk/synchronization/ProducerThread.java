package com.jpk.synchronization;

import java.util.Random;

public class ProducerThread
    implements Runnable
{

    private Main refToMain;
    
    
    
    public ProducerThread( Main mainObject )
    {
        this.refToMain=mainObject;
    }


    @Override
    public void run(){
   
        producer();
  
    }
    public void producer() 
    {
        Random random = new Random();

        while( true )
        {
            try
            {
                refToMain.getQueue().put( random.nextInt( 100 ) );
            }
            catch( InterruptedException e )
            {
                e.printStackTrace();
            }
        }
    }
}
