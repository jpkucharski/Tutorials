package com.jpk.lambdaTest;

interface Executable    //interface with one method we call "functional interface"
{
    void execute();
}


class Runner
{
    public void run( Executable e )
    {
        System.out.println( "Executable code block..." );
        e.execute();
    }

}


public class App1
{
    public static void main( String arg[] )
    {
        Runner runner = new Runner();
        runner.run( new Executable()
        {
            public void execute()
            {
                System.out.println( "Hello there from Executable instance" );
            }
        } );

        System.out.println( "---------------------------------------" );

        runner.run( () -> {
            System.out.println( "Hello there 1 from Lambda" );
            System.out.println( "Hello there 2 from Lambda" );
        } );
    }
}
