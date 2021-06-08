package com.orion.lesson12;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.orion.lesson12.SpringStart.Timer;

@Configuration
@ComponentScan("com.orion.lesson12")
@EnableScheduling
@EnableCaching
public class SpringConfiguration extends CachingConfigurerSupport {


    @Bean
    public DateTimeFormatter formatter() {
        timer().start("f1");
        final DateTimeFormatter result = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        timer().end();
        return result;
    }

    @Bean
    public DateTimeFormatter formatter2() {
        timer().start("f2");
        final DateTimeFormatter result = DateTimeFormatter.ofPattern("HH:mm");
        timer().end();
        return result;
    }


    @Bean
    public Timer timer() {
        return new Timer();
    }



    @Bean
    public CacheManager cacheManager() {
        System.out.println("Создается CacheManager");
        // configure and return an implementation of Spring's CacheManager SPI
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("url-retreiver-cache")));
        return cacheManager;
    }
}
