package com.ubicompsystem.dojo.statemachine;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class RoomReservationStatusTest {
    @Parameters
    public static Iterable<Object> parameters(){
        return Arrays.asList( RoomReservationStatus.values() );
    }

    RoomReservationStatus testStatus;

    public RoomReservationStatusTest( RoomReservationStatus status ){
        this.testStatus = status;
    }

    @Test
    public void defaultTest(){
        System.out.println( "Status - " + this.testStatus.name() );

        System.out.println( "Forward Status - " );
        for( State forwardState : this.testStatus.forwardStates() ){
            if( forwardState instanceof RoomReservationStatus ){
                System.out.println( "\t " + ((RoomReservationStatus)forwardState).name() );
            }
        }

        System.out.println( "Backward Status - " );
        for( State backwardState : this.testStatus.backwardStates() ){
            if( backwardState instanceof RoomReservationStatus ){
                System.out.println( "\t " + ( (RoomReservationStatus) backwardState).name() );
            }
        }
        System.out.println( "END Status - " + this.testStatus.name() + "\n" );
    }
}
