package com.jpk.synchronization;

public class ThreadX
    implements Runnable
{
    private Variable refToVariableObject;


    public ThreadX( Variable refToObject )
    {
        this.refToVariableObject = refToObject;
    }


    @Override
    public void run()
    {
        for( int i = 0; i < 10000000; i++ )
        {
            treadTask(refToVariableObject);
        }
    }


    private void treadTask(Variable ref)
    {
        int resultOfInclementation = ref.inclementation( ref.getCounter() );
        ref.setCounter( resultOfInclementation );
    }
}
