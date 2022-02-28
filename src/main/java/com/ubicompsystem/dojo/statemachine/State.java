package com.ubicompsystem.dojo.statemachine;

import java.lang.reflect.Array;

public interface State<T> {
    T[] forwardStates();
    T[] backwardStates();
    default T[] adjacentStates(){
        T[] forwardStates = forwardStates();
        T[] backwardStates = backwardStates();
        int forwardStatesLength = (forwardStates!=null)?forwardStates.length:0;
        int backwardStatesLength = (backwardStates!=null)?backwardStates.length:0;
        Class<?> compType = null;
        if( forwardStates != null ){
            compType = forwardStates.getClass().getComponentType();
        }

        if( compType != null ){
            try{
                @SuppressWarnings("unchecked")
                T[] adjacentStates = (T[]) Array.newInstance( compType, forwardStatesLength + backwardStatesLength );
                if( forwardStates != null ){
                    System.arraycopy( forwardStates, 0, adjacentStates, 0, forwardStatesLength );
                }

                if( backwardStates != null ){
                    System.arraycopy( backwardStates, 0, adjacentStates, forwardStatesLength, backwardStatesLength );
                }
                return adjacentStates;
            } catch( NegativeArraySizeException negativeArray ){
            }
        }
        return null;
    };
}
