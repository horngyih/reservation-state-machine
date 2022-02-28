package com.ubicompsystem.dojo.statemachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class RoomReservationStatusStateDiagramTest {

    public static final String TERMINAL = "[*]";

    @Test
    public void stateDiagramTest(){
        Set<String> edges = new HashSet<>();
        for( RoomReservationStatus status : RoomReservationStatus.values() ){
            RoomReservationStatus[] backwardStates = status.backwardStates();
            RoomReservationStatus[] forwardStates = status.forwardStates();
            if( backwardStates.length <= 0 ){
                edges.add( TERMINAL + " --> " + status.name() );
            } else {
                edges.addAll( edges( status, backwardStates ) );
            }
            edges.addAll( edges( status, forwardStates ) );
        }

        List<String> edgeList = new ArrayList<>(edges);
        Collections.sort(edgeList, Collections.reverseOrder());
        for( String edge : edgeList ){
            System.out.println( edge );
        }
    }

    protected static Set<String> edges( RoomReservationStatus origin, RoomReservationStatus[] endPoints ){
        Set<String> edges = new HashSet<>();
        if( endPoints != null && endPoints.length > 0 ){
            for( RoomReservationStatus endpoint : endPoints ){
                edges.add( origin.name() + " --> " + endpoint.name() );
            }
        }
        return edges;
    }
}
