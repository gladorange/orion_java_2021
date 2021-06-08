package com.orion.lesson12;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringStart {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        final PrintCurrentDateService bean = context.getBean(PrintCurrentDateService.class);
        bean.printCurrentTime();

        final DateTimeFormatter formatter = (DateTimeFormatter) context.getBean("formatter");
        final DateTimeFormatter formatter2 = (DateTimeFormatter) context.getBean("formatter2");

        System.out.println(formatter.format(LocalDateTime.now()));
        System.out.println(formatter2.format(LocalDateTime.now()));





    }


    public static class Timer {

        Long start;
        private String mark;

        public  void start(String mark) {
            this.mark = mark;
            start = System.nanoTime();
       }


       public void end() {
           System.out.println(mark +":" +(System.nanoTime() - start));

       }
    }


}
