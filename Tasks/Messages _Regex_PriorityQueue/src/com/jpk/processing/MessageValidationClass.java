package com.jpk.processing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class MessageValidationClass
{

    private final  String INSTRUCTION_TYPE_PATERN = "[ABCD]";
    private final String PRODUCT_CODE_PATERN = "^[A-Z]{2}[0-9]{2}";
    private final String TIMESTAMP_PATERN = "yyyyMMdd'T'HH:mm:ss.SSS'Z'";


    public boolean validation( InstructionMessage message )
    {

        Calendar actualTime = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern( TIMESTAMP_PATERN );
        Calendar messageTimeCalendar = null;
        long messageTimeUnix = 0;

        try
        {
            Date messageTimeDate = (Date)df.parse( message.getTimeStamp() );
            messageTimeCalendar = Calendar.getInstance();
            messageTimeCalendar.setTime( messageTimeDate );
            messageTimeUnix = messageTimeCalendar.getTimeInMillis() / 1000;
            messageTimeCalendar.setTimeInMillis( messageTimeUnix * 1000 );
         
        }
        catch( ParseException e )
        {
            e.printStackTrace();
        }

        boolean validation = false;
        if( message.getInstructionTyp().matches( INSTRUCTION_TYPE_PATERN ) )
        {
            if( message.getProductCode().matches( PRODUCT_CODE_PATERN ) )
            {
                if( Integer.parseInt( message.getQuantity() ) > 0 )
                {
                    if( Integer.parseInt( message.getUom() ) >= 0 && Integer.parseInt( message.getUom() ) < 256 )
                    {
                        if( messageTimeUnix > 0 && messageTimeCalendar.before( actualTime ) || messageTimeCalendar.equals( actualTime ) )
                        {
                            validation = true;
                        }
                    }
                }
            }
        }
        return validation;
    }
}
