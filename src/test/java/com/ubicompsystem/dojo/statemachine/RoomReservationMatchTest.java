package com.ubicompsystem.dojo.statemachine;

import java.util.*;

import static org.junit.Assert.*;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class RoomReservationMatchTest {
    @Parameters
    public static Iterable<Object> reservationStatus(){
        return Arrays.asList(ReservationStatus.values());
    }

    ReservationStatus testStatus;

    public RoomReservationMatchTest( ReservationStatus status ){
        this.testStatus = status;
    }

    @Test
    public void defaultTest(){
        System.out.println( "Matching status for " + testStatus.name() );
        RoomReservationStatus roomStatus = RoomReservationStatus.valueOf(testStatus.name());
        assertNotNull("Should have a matching RoomReservationStatus for " + testStatus.name(), roomStatus );
    }
}
