package com.jpk.synchronization;

public class Main
{
    public static void main(String[] args){
        
        final Methods mainClassObject = new Methods();
        
        Thread thread1 = new Thread(new Runnable()
        {
            
            @Override
            public void run()
            {
                try
                {
                    mainClassObject.produce();
                }
                catch( InterruptedException e )
                {
                    e.printStackTrace();
                }
                
            }
        });
        
        Thread thread2 = new Thread( new Runnable(){

            @Override
            public void run()
            {
                try
                {
                    mainClassObject.consume();
                }
                catch( InterruptedException e )
                {
                    e.printStackTrace();
                }
                
            }
            
        });
        
        thread1.start();
        thread2.start();
        
    }
}
