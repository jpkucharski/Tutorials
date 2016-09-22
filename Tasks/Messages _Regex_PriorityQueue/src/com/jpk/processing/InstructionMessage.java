package com.jpk.processing;

public class InstructionMessage
{
    private String instructionTyp;
    private String productCode;
    private String quantity;
    private String uom;
    private String timeStamp;
    private String message;


    public InstructionMessage( String message )
    {
        this.message = message;
        String[] splitedMessage = message.split( "\\s+" );
        this.instructionTyp = splitedMessage[0];
        this.productCode = splitedMessage[1];
        this.quantity = splitedMessage[2];
        this.uom = splitedMessage[3];
        this.timeStamp = splitedMessage[4];
    }

    public String getMessage()
    {
        return message;
    }
    
    
    public String getInstructionTyp()
    {
        return instructionTyp;
    }


    public String getProductCode()
    {
        return productCode;
    }


    public String getQuantity()
    {
        return quantity;
    }


    public String getUom()
    {
        return uom;
    }


    public String getTimeStamp()
    {
        return timeStamp;
    }

}
