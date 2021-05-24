package com.orion.lesson7;

import java.util.EnumSet;

public class EnumSetExample {


    static int IS_WRITABLE = 1;
    static int IS_WHITE_COLOR = 2;
    static int IS_SQUARE = 4;


    static int state = 7;




    enum ObjectState {
        IS_WRITABLE,
        IS_WHITE_COLOR,
                IS_SQUARE,
    }


    static EnumSet<ObjectState> stateSet = EnumSet.of(ObjectState.IS_WRITABLE, ObjectState.IS_WHITE_COLOR, ObjectState.IS_SQUARE);

    public static void main(String[] args) {


        System.out.println(state & IS_SQUARE & IS_WRITABLE & IS_WRITABLE);


        System.out.println(stateSet.contains(ObjectState.IS_WRITABLE)
                && stateSet.contains(ObjectState.IS_WHITE_COLOR)
                && stateSet.contains(ObjectState.IS_SQUARE)
        );


    }

}
