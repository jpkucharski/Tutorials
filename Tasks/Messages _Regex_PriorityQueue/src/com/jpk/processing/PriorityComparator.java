package com.jpk.processing;

import java.util.Comparator;


public class PriorityComparator
    implements Comparator<InstructionMessage>
{

    @Override
    public int compare( InstructionMessage arg1, InstructionMessage arg0 )
    {

        if( arg0.getInstructionTyp().equals( "A" ) )
        {
            return 1;
        }

        if( arg0.getInstructionTyp().equals( "B" ) && arg1.getInstructionTyp().equals( "A" ) )
        {
            return -1;
        }
        if( arg0.getInstructionTyp().equals( "B" ) && arg1.getInstructionTyp().equals( "C" ) )
        {
            return -1;
        }
        if( arg0.getInstructionTyp().equals( "B" ) && arg1.getInstructionTyp().equals( "D" ) )
        {
            return -1;
        }

        if( arg0.getInstructionTyp().equals( "C" ) && arg1.getInstructionTyp().equals( "A" ) )
        {
            return -1;
        }
        if( arg0.getInstructionTyp().equals( "C" ) && arg1.getInstructionTyp().equals( "B" ) )
        {
            return -1;
        }
        if( arg0.getInstructionTyp().equals( "C" ) && arg1.getInstructionTyp().equals( "D" ) )
        {
            return 1;
        }

        if( arg0.getInstructionTyp().equals( "D" ) && arg1.getInstructionTyp().equals( "A" ) )
        {
            return -1;
        }
        if( arg0.getInstructionTyp().equals( "D" ) && arg1.getInstructionTyp().equals( "B" ) )
        {
            return -1;
        }
        if( arg0.getInstructionTyp().equals( "D" ) && arg1.getInstructionTyp().equals( "C" ) )
        {
            return -1;
        }

        return 0;
    }

}
