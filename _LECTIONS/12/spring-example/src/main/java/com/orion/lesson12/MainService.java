package com.orion.lesson12;


import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainService {


    ByteCounter byteCounter;
    CountA countA;

    public MainService() {

    }


    @PostConstruct
    private void init() {
        final Map<String, Integer> wordCount = byteCounter
                .countBytes("https://mvnrepository.com/artifact/commons-io/commons-io/2.9.0",
                        "https://stackoverflow.com/questions/51684872/spring-postconstruct-is-not-called-on-maven-tests-but-works-fine-if-test-is-r");

        System.out.println(wordCount);


        final Map<String, Integer> aCount = countA
                .countA("https://mvnrepository.com/artifact/commons-io/commons-io/2.9.0",
                        "https://stackoverflow.com/questions/51684872/spring-postconstruct-is-not-called-on-maven-tests-but-works-fine-if-test-is-r");


        System.out.println(aCount);
    }

    @Autowired
    public void setByteCounter(ByteCounter byteCounter) {
        this.byteCounter = byteCounter;
    }

    @Autowired
    public void setCountA(CountA countA) {
        this.countA = countA;
    }
}
