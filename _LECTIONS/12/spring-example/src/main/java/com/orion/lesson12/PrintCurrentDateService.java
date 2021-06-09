package com.orion.lesson12;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PrintCurrentDateService {



    final DateTimeFormatter someFormatter;


    public PrintCurrentDateService(@Qualifier("formatter2") DateTimeFormatter someFormatter) {
        this.someFormatter = someFormatter;
    }



    @Scheduled(fixedRate = 2000)
    public void printCurrentTime() {
        System.out.println(someFormatter.format(LocalDateTime.now()));
    }




}
