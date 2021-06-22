package com.orion.java.homework4;


import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class UnitTest {
    @Test
    public void addUnitTestException(){
        Unit.Grid grid = new Unit.Grid();
        Unit vasya = new Unit(0,0,10,"Vasya",grid);
        grid.add(vasya);
        Exception exceptionBox = assertThrows(IllegalArgumentException.class, () -> {
            Unit kolya = new Unit(0,0,10,"Kolya",grid);
            grid.add(kolya);
        });
        String expectedMessage = "Error:There is an unit!";
        String actualMessageBox = exceptionBox.getMessage();

        assertTrue(actualMessageBox.contains(expectedMessage));

        Unit petya = new Unit(0,11,10,"Petya",grid);
        Exception exceptionBox1 = assertThrows(IllegalArgumentException.class, () -> {
            grid.add(petya);
        });
        String expectedMessage1 = "Error:Cell number can't be more than "+ Unit.Grid.NUM_CELLS;
        String actualMessageBox1 = exceptionBox1.getMessage();

        assertTrue(actualMessageBox1.contains(expectedMessage1));

    }
    @Test
    public void moveUnitTestException(){
        Unit.Grid grid = new Unit.Grid();
        Unit vasya = new Unit(0,0,10,"Vasya",grid);
        grid.add(vasya);
        Unit kolya = new Unit(0,1,10,"Kolya",grid);
        grid.add(kolya);
        Exception exceptionBox = assertThrows(IllegalArgumentException.class, () -> {
            kolya.move(0,0);
        });
        String expectedMessage = "Error:There is an unit!";
        String actualMessageBox = exceptionBox.getMessage();

        assertTrue(actualMessageBox.contains(expectedMessage));
    }

}
