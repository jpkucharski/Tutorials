package com.jpk.synchronization;

import java.util.ArrayList;
import java.util.List;

public class Main
{

    
    public static void main(String[] args){
        
        TicketsReservation reservstionInstance = new TicketsReservation();
        List<CustomerThread> listOfCustomers = new ArrayList<>();
       
        CustomerThread customer1 = new CustomerThread(2, reservstionInstance,"Anna");
        CustomerThread customer2 = new CustomerThread(4, reservstionInstance,"Natalia");
        CustomerThread customer3 = new CustomerThread(6, reservstionInstance,"Ola");
        
        
        
        listOfCustomers.add( customer1 );
        listOfCustomers.add( customer2 );
        listOfCustomers.add( customer3 );
     
    for ( CustomerThread c: listOfCustomers ){
           c.start();
       }
    }
}
