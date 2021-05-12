package testcases;


import com.orion.java.Main;
import org.junit.Assert;
import org.junit.Test;


/**
 *  Класс,содержащий методы для тестирование методов
 *  isMagicNumber(int number) и isDifferentSignum(int firstNumber,int secondNumber).
 */
public class TestCases {
    @Test
    /**
     * Метод для тестирования метода boolean isMagicNumber(int number).
     */
    public void isMagicNumberFunctionTest()  throws Exception{
        Assert.assertEquals(Main.isMagicNumber(0),false);
        Assert.assertEquals(Main.isMagicNumber(5),false);
        Assert.assertEquals(Main.isMagicNumber(-5),false);
        Assert.assertEquals(Main.isMagicNumber(55),true);
        Assert.assertEquals(Main.isMagicNumber(-55),true);
        Assert.assertEquals(Main.isMagicNumber(Integer.MAX_VALUE),false);
        Assert.assertEquals(Main.isMagicNumber(Integer.MIN_VALUE),false);
    }

    @Test
    /**
     * Метод для тестирования метода int isDifferentSignum(int firstNumber,int secondNumber).
     */
    public void isDifferentSignumFunctionTest()  throws Exception{

        Assert.assertEquals(Main.isDifferentSignum(0,0),0);
        Assert.assertEquals(Main.isDifferentSignum(0,1),0);
        Assert.assertEquals(Main.isDifferentSignum(0,-1),0);
        Assert.assertEquals(Main.isDifferentSignum(1,0),0);
        Assert.assertEquals(Main.isDifferentSignum(-1,0),0);



        Assert.assertEquals(Main.isDifferentSignum(-5,5),1);
        Assert.assertEquals(Main.isDifferentSignum(5,5),-1);
        Assert.assertEquals(Main.isDifferentSignum(Integer.MAX_VALUE,Integer.MAX_VALUE-1),-1);
        Assert.assertEquals(Main.isDifferentSignum(Integer.MAX_VALUE,Integer.MAX_VALUE+1),1);

        Assert.assertEquals(Main.isDifferentSignum(Integer.MIN_VALUE,Integer.MIN_VALUE-1),1);
        Assert.assertEquals(Main.isDifferentSignum(Integer.MIN_VALUE,Integer.MIN_VALUE+1),-1);
    }

}
