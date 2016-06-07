package com.jpk.synchronization;

public class ThreadX
    implements Runnable

{
    Variable refToVariableClassObject;


    public ThreadX( Variable refToVariableObject )
    {
        this.refToVariableClassObject = refToVariableObject;
    }


    @Override
    public void run()
    {
        refToVariableClassObject.process();
    }
}
