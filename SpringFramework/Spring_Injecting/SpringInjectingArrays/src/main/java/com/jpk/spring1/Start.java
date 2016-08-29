package com.jpk.spring1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jpk.spring1.service.MessagePrinter;


public class Start
{
    public static void main( final String[] args )
    {
        try (final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( "spring/application.xml" ))
        {
            context.registerShutdownHook();
            final MessagePrinter printer = context.getBean( "printer", MessagePrinter.class );
            String finalMessage = printer.printMessage();
            System.out.println( finalMessage );
        }
        catch( final Exception e )
        {
            e.printStackTrace();
        }
    }
}