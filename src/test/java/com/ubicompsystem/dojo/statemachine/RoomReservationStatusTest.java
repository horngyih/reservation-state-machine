package com.ubicompsystem.dojo.statemachine;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class RoomReservationStatusTest {
    @Parameters(name="{1}")
    public static Iterable<Object[]> parameters(){
        List<Object[]> parameters = new ArrayList<>();
        for( RoomReservationStatus status : RoomReservationStatus.values() ){
            parameters.add( new Object[]{ status.name(), status } );
        }
        return parameters;
    }

    String statusName;
    RoomReservationStatus testStatus;

    public RoomReservationStatusTest( String name, RoomReservationStatus status ){
        this.statusName = name;
        this.testStatus = status;
    }

    @Test
    public void defaultTest(){
        System.out.println( "Status - " + this.testStatus.name() );

        System.out.println( "Forward Status - " );
        for( RoomReservationStatus forwardState : this.testStatus.forwardStates() ){
            System.out.println( "\t " + forwardState.name() );
        }

        System.out.println( "Backward Status - " );
        for( RoomReservationStatus backwardState : this.testStatus.backwardStates() ){
            System.out.println( "\t " + backwardState.name() );
        }

        System.out.println( "Adjacent Status - " );
        RoomReservationStatus[] adjacentStates = this.testStatus.adjacentStates();
        for( RoomReservationStatus adjecentState : adjacentStates ){
            System.out.println( "\t " + adjecentState.name() );
        }
        System.out.println( "END Status - " + this.testStatus.name() + "\n" );
    }
}
