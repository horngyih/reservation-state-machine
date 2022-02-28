package com.ubicompsystem.dojo.statemachine;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class ReservationStatusTest {
    @Parameters
    public static Iterable<Object> parameters(){
        return Arrays.asList( ReservationStatus.values() );
    }

    ReservationStatus testStatus;

    public ReservationStatusTest( ReservationStatus status ){
        this.testStatus = status;
    }

    @Test
    public void defaultTest(){
        System.out.println( "Status - " + this.testStatus.name() );

        System.out.println( "Forward Status - " );
        for( State forwardState : this.testStatus.forwardStates() ){
            if( forwardState instanceof ReservationStatus ){
                System.out.println( "\t " + ((ReservationStatus)forwardState).name() );
            }
        }

        System.out.println( "Backward Status - " );
        for( State backwardState : this.testStatus.backwardStates() ){
            if( backwardState instanceof ReservationStatus ){
                System.out.println( "\t " + ( (ReservationStatus) backwardState).name() );
            }
        }
        System.out.println( "END Status - " + this.testStatus.name() + "\n" );
    }
}
