package com.jpk.synchronization;

public class TicketsReservation
    implements Runnable
{

    private int totalSeatsAvailable = 10;


    @Override
    public void run()
    {

        CustomerThread actualCustomerThread = (CustomerThread)Thread.currentThread();
        boolean ticketBoocked = bookTickets( actualCustomerThread.getTicketsNeeded(), actualCustomerThread.getName() );
        if( ticketBoocked == true )
        {
            System.out.println(
                "Hello, " + actualCustomerThread.getName() + " You habe booked: " + actualCustomerThread.getTicketsNeeded() + " tickers." );
        }
        else
        {
            System.out.println( "Sorry, " + actualCustomerThread.getName() + " we have only: " + totalSeatsAvailable + " tickers left." );
        }
    }


    private boolean bookTickets( int quantityNeeded, String nameOfCustomer )
    {
        synchronized( this )
        {

            System.out.println( "Hello: " + Thread.currentThread().getName() + ", available tickets namber is: " + totalSeatsAvailable );

            if( quantityNeeded > this.getTotalSeatsAvailable() )
            {
                return false;

            }
            else
            {
                totalSeatsAvailable = totalSeatsAvailable - quantityNeeded;
                return true;
            }
        }

    }


    public int getTotalSeatsAvailable()
    {
        return totalSeatsAvailable;
    }

}
