package com.jpk.threads;

public class Main
{
    public static void main( String[] args )
    {
        for( int i = 0; i <= 3; i++ )
        {
            ThreadX threadObject = new ThreadX( Integer.toString( i ) );
            threadObject.start();
        }
        new ThreadX( "ThreadID" ).start();
    }
}
