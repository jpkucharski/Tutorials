package com.jpk.simpleJPAConnection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main
{

    public static void main( String[] args )
    {
        
        
        EntityManagerFactory entytyManagerFactory = Persistence.createEntityManagerFactory( "persistenceName" );
        EntityManager entityManager = entytyManagerFactory.createEntityManager();
        
        entityManager.close();
        entytyManagerFactory.close();

    }

}
