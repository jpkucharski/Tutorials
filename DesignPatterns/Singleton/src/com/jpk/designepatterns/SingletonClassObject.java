package com.jpk.designepatterns;

public class SingletonClassObject
{
//    only one instance
    private static SingletonClassObject instance = new SingletonClassObject();

//   private constructor
    private SingletonClassObject(){
    }

// only object available
    public static SingletonClassObject getInstance(){
       return instance;
    }

    public void showMessage(){
       System.out.println("Message from singleton class");
    }
}
