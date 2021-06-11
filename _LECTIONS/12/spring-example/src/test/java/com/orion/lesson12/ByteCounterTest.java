package com.orion.lesson12;

import static org.mockito.Mockito.*;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ByteCounterTest {

    ExecutorService executorService = Executors.newFixedThreadPool(Integer.getInteger("thread-count",40));

/*

    public static class TestUrlRetriveer extends UrlRetriever {
        @Override
        public String getContent(String url) {
            return "this is content";
        }
    }
*/

    final UrlRetriever mock = mock(UrlRetriever.class);




    @Test
    public void testCounter() {


        when(mock.getContent(any())).thenReturn("this is content");

        final Map<String, Integer> result = new ByteCounter(mock, new NotASpringBean()).countBytes("https://stackoverflow.com/questions/51684872/spring-postconstruct-is-not-called-on-maven-tests-but-works-fine-if-test-is-r");

        final int integer = result.get("https://stackoverflow.com/questions/51684872/spring-postconstruct-is-not-called-on-maven-tests-but-works-fine-if-test-is-r");
        Assert.assertNotNull("Site should be available",integer);
        Assert.assertEquals("Size should be 3",integer,3);
        Assert.assertEquals("Size should be 1",result.size(),1);


        Assert.assertNull(result.get("bad url"));


    }

    @Test
    public void testDoSomething() {
/*        final Map<String, Integer> result = new ByteCounter(new TestUrlRetriveer(), new NotASpringBean()).countBytes("https://stackoverflow.com/questions/51684872/spring-postconstruct-is-not-called-on-maven-tests-but-works-fine-if-test-is-r");

        final int integer = result.get("https://stackoverflow.com/questions/51684872/spring-postconstruct-is-not-called-on-maven-tests-but-works-fine-if-test-is-r");
        Assert.assertNotNull("Site should be available", integer);
        Assert.assertEquals("Size should be 3", integer, 3);
        Assert.assertEquals("Size should be 1", result.size(), 1);


        Assert.assertNull(result.get("bad url"));*/


    }

}
