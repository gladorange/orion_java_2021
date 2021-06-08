package com.orion.java.homework7.testcases;




import com.orion.java.homework7.Box;
import com.orion.java.homework7.NumberBox;
import com.orion.java.homework7.StringBoxUtils;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static com.orion.java.homework7.StringBoxUtils.copyNonEmptyStringBoxToList;
import static org.junit.Assert.*;

public class TestCases {




    @Test
    public void testBoxOfException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Box<Integer> firstBox = Box.of(null);
        });

        String expectedMessage = "Error:Value can't be null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    /**
     *  Тестирование конструкторов классов Box и BoxNumber.
     */
    public void testNumberBoxOfException() {
        Exception exceptionBox = assertThrows(IllegalArgumentException.class, () -> {
            Box<Integer> firstBox = Box.of(null);
        });

        String expectedMessage = "Error:Value can't be null";
        String actualMessageBox = exceptionBox.getMessage();

        assertTrue(actualMessageBox.contains(expectedMessage));

        Exception exceptionBoxNumber = assertThrows(IllegalArgumentException.class, () -> {
            NumberBox third = NumberBox.of(null);
        });
        String actualMessageBoxNumber = exceptionBox.getMessage();
        assertTrue(actualMessageBoxNumber.contains(expectedMessage));
    }

    @Test
    /**
     * Тестирование создание объектов класса Box.
     */
    public void testBoxOfValue()  throws Exception{
        Box<Integer> firstBoxInteger = Box.of(Integer.MAX_VALUE);
        assertEquals((Integer) firstBoxInteger.getValue(), (Integer)Integer.MAX_VALUE);
        Box<Integer> secondBoxInteger = Box.of(Integer.MIN_VALUE);
        assertEquals((Integer)secondBoxInteger.getValue(), (Integer)Integer.MIN_VALUE);

        Box<Long> firstBoxLong = Box.of(Long.MAX_VALUE);
        assertEquals( (Long) firstBoxLong.getValue(),(Long)Long.MAX_VALUE);
        Box<Long> secondBoxLong = Box.of(Long.MIN_VALUE);
        assertEquals( (Long) secondBoxLong.getValue(),(Long)Long.MIN_VALUE);

        Box<Double> firstBoxDouble = Box.of(Double.MAX_VALUE);
        assertEquals( (Double) firstBoxDouble.getValue(),(Double)Double.MAX_VALUE,0.0);
        Box<Double> secondBoxDouble = Box.of(Double.MIN_VALUE);
        assertEquals( (Double) secondBoxDouble.getValue(),(Double)Double.MIN_VALUE,0.0);

        Box<Float> firstBoxFloat = Box.of(Float.MAX_VALUE);
        assertEquals( (Float) firstBoxFloat.getValue(),(Float)Float.MAX_VALUE,0.0);
        Box<Float> secondBoxFloat = Box.of(Float.MIN_VALUE);
        assertEquals( (Float) secondBoxFloat.getValue(),(Float)Float.MIN_VALUE,0.0);

        Box<Byte> firstBoxByte = Box.of(Byte.MAX_VALUE);
        assertEquals( (Byte) firstBoxByte.getValue(),(Byte)Byte.MAX_VALUE);
        Box<Byte> secondBoxByte = Box.of(Byte.MIN_VALUE);
        assertEquals( (Byte) secondBoxByte.getValue(),(Byte)Byte.MIN_VALUE);

        Box<Short> firstBoxShort  = Box.of(Short.MAX_VALUE);
        assertEquals( (Short) firstBoxShort.getValue(),(Short)Short.MAX_VALUE);
        Box<Short> secondBoxShort = Box.of(Short.MIN_VALUE);
        assertEquals((Short) secondBoxShort.getValue(),(Short)Short.MIN_VALUE);
    }

    @Test
    /**
     * Тестирование методов сложение и умножения класса BoxNumber.
     */
    public void testBoxNumberMetods()  throws Exception{
        Box<Float> firstBox = Box.of(1.3f);
        Box<Long> secondBox = Box.of(2L);
        NumberBox third = NumberBox.of(3);
        assertEquals( (Double) third.add(secondBox).multiply(firstBox).getValue(),(Double)6.5 ,0.000001);

        Box<Integer> firstBox1 = Box.of(2);
        Box<Long> secondBox1 = Box.of(2L);
        NumberBox third1 = NumberBox.of(3.14);
        assertEquals( (Double) third1.add(secondBox1).multiply(firstBox1).getValue(),(Double)10.28 ,0.000001);
    }
    @Test
    /**
     * Тестирование методов  класса StringBoxUtils.
     */
    public void testStringBoxUtilsMetods()  throws Exception{

        //Ничего не добавиться
        List<String> expected =  new ArrayList<>();
        List<String > emptyList = new ArrayList<>();
        copyNonEmptyStringBoxToList(Box.of("     "), emptyList);
        assertEquals(expected, emptyList);

        String first = "сорок два";
        expected.add(first);
        copyNonEmptyStringBoxToList(Box.of(first), emptyList);
        assertEquals(expected, emptyList);

        String second = "some value";
        expected.add(second);
        copyNonEmptyStringBoxToList(Box.of(second), emptyList);
        assertEquals(expected, emptyList);

        Box<? extends CharSequence> boxStr = StringBoxUtils.join(Box.of("|Ты|_"),Box.of("|и|"),Box.of("_|Я|."));
        String expectedStr = "|Ты|_|и|_|Я|.";
        assertEquals(expectedStr, boxStr.getValue());

        List<Box<? extends CharSequence>> boxesList = new ArrayList<>();
        boxesList.add(Box.of("|Ты|"));
        boxesList.add(Box.of("_|и|"));
        boxesList.add(Box.of("_|Я|."));
        assertEquals(expectedStr,StringBoxUtils.join( boxesList ).getValue());

    }


}
