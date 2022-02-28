package com.ubicompsystem.dojo.statemachine;

import static java.lang.System.arraycopy;

import java.lang.reflect.Array;

public interface State<T> {
    T[] forwardStates();
    T[] backwardStates();
    default T[] adjacentStates(){
        return concatenateNew(forwardStates(), backwardStates());
    };

    static <Arr> Arr concatenateNew( Arr arr1, Arr arr2 ){
        if( arr1 == null && arr2 == null ){
            return null;
        }

        Class<?> arr1Type = (arr1!=null)?arr1.getClass().getComponentType():null;
        Class<?> arr2Type = (arr2!=null)?arr2.getClass().getComponentType():null;

        if( arr1Type == null || arr2Type == null || !arr1Type.equals(arr2Type) ){
            throw new IllegalArgumentException( "Cannot concatenate Arrays of different Types" );
        }

        Class<?> compType = arr1Type;

        int arr1Length = (arr1!=null)?Array.getLength(arr1):0;
        int arr2Length = (arr2!=null)?Array.getLength(arr2):0;

        @SuppressWarnings("unchecked")
        Arr result = (Arr) Array.newInstance(compType, arr1Length + arr2Length);

        if( arr1Length + arr2Length > 0 ){
            arraycopy( arr1,  0, result, 0, arr1Length );
            arraycopy( arr2, 0, result, arr1Length, arr2Length );
        }
        return result;
    }
}
