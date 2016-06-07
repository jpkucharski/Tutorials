package com.jpk.synchronization;

public class Main
{

    public static void main( String[] args )
    {
        Variable refToVariableClassObject = new Variable();
        for( int i = 0; i < 10; i++ )
        {
            Thread thread = createThread( new ThreadX( refToVariableClassObject ) );
            thread.start();
            try
            {
                thread.join();
            }
            catch( InterruptedException e )
            {
                e.printStackTrace();
            }
        }
        System.out.println( refToVariableClassObject.getCounter() );
    }

    private static Thread createThread( Runnable threadClassObject )
    {
        return new Thread( threadClassObject );
    }
}
