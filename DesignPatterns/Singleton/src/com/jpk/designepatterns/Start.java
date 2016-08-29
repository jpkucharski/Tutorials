package com.jpk.designepatterns;

public class Start
{

    public static void main(String[] args){
        
//        illegal constructor
//        SingletonObject object = new SingletonObject();
       
        
//        correct construction
      
        SingletonClassObject object = SingletonClassObject.getInstance();
        object.showMessage();
       
      
    }
}
