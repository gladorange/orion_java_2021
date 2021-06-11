package com.mer.spring;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import com.mer.spring.dto.Person;
import com.mer.spring.person.PersonRepository;
import com.mer.spring.person.PersonService;

@Configuration
@ComponentScan
//@EnableScheduling
//@EnableCaching
public class ApplicationConfig extends CachingConfigurerSupport implements SchedulingConfigurer {


    public static class SalaryService {

        final PersonRepository personRepository;

        public SalaryService(PersonRepository personRepository) {
            this.personRepository = personRepository;
        }

        @PostConstruct
        void doSalaryCalculation() {
            for (Person person : personRepository.findAll()) {
                System.out.println("Начисляю зарплату " + person.getLastName());
            }

        }
    }






/*

    @Bean
    public PersonRepository personRepository() {
        System.out.println("Создается Person repository");
        return new PersonRepository();
    }

    @Bean
    public PersonService personService() {
        return new PersonService(personRepository());
    }

*/

    @Bean
    public SalaryService salaryService(PersonRepository personRepository) {
        return new SalaryService(personRepository);
    }


    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean(destroyMethod="shutdown")
    public ExecutorService taskExecutor() {
        return Executors.newScheduledThreadPool(2);
    }


   // @Bean
   // @Override
    public CacheManager cacheManager() {
        System.out.println("Создается CacheManager");
        // configure and return an implementation of Spring's CacheManager SPI
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("persons")));
        return cacheManager;
    }


}
