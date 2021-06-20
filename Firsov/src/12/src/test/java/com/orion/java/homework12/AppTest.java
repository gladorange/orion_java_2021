package com.orion.java.homework12;

import static framework.SimpleDIFramework.injectedDependency;
import static org.junit.Assert.*;


import com.orion.java.homework12.annotations.AutowireSimpleComponent;
import com.orion.java.homework12.components.Cat;
import com.orion.java.homework12.testClass.Person;
import framework.SimpleDIFramework;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.InvocationTargetException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @AutowireSimpleComponent
    private Person person;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testWhenInputStringIsNull() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Error: basePackagesToScan can't be null");
        injectedDependency(null);
    }
    @Test
    public void testWhenNoAnnotationsInClass() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        exceptionRule.expect(NullPointerException.class);
      //  exceptionRule.expectMessage("Error: basePackagesToScan can't be null");
        new SimpleDIFramework("com.orion.java.homework12.testClass");
     //   injectedDependency("com.orion.java.homework12.testClass");
    }

}
