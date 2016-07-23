package com.jpk.lambdaTest;

interface Executable1
{
    int execute1();
}


class Runner1
{

    public void run1( Executable1 e1 )
    {
        System.out.println( "Executable1 code block..." );
        int value = e1.execute1();
        System.out.println( "Returned value is:" + value );

    }

}

/*
 * () -> { 
 *          System.out.println( "Value returned from Lambda" );
 *          return 8;
 *       }
 */
// ()-> 9





public class App
{
    public static void main( String arg[] )
    {
        Runner1 runner1 = new Runner1();
        runner1.run1( new Executable1()
        {
            public int execute1()
            {
                System.out.println( "Hello there from Executable" );
                return 7;
            }
        } );

        System.out.println( "---------------------------------------" );

        runner1.run1( () -> {
            System.out.println( "Value returned from Lambda" );
            return 8;
        } );
        
        runner1.run1( () -> 9 );
    }
}
