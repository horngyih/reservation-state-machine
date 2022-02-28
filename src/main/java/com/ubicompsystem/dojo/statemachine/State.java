package com.ubicompsystem.dojo.statemachine;

public interface State {
    State[] forwardStates();
    State[] backwardStates();
    default State[] adjacentStates(){
        State[] forwardStates = forwardStates();
        State[] backwardStates = backwardStates();
        int forwardStatesLength = (forwardStates!=null)?forwardStates.length:0;
        int backwardStatesLength = (backwardStates!=null)?backwardStates.length:0;
        State[] adjacentStates = new State[forwardStatesLength+backwardStatesLength];
        if( forwardStates != null ){
            System.arraycopy( forwardStates, 0, adjacentStates, 0, forwardStatesLength );
        }

        if( backwardStates != null ){
            System.arraycopy( backwardStates, 0, adjacentStates, forwardStatesLength, backwardStatesLength );
        }
        return adjacentStates;
    };
}
