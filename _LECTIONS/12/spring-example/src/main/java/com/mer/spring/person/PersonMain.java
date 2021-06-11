package com.mer.spring.person;

import org.springframework.stereotype.Component;

import com.mer.spring.dto.Person;

public class PersonMain {


    @Component
    static class SalaryService {
        final PersonRepository repository;

        SalaryService(PersonRepository repository) {
            this.repository = repository;
        }


        public void sendSalary() {
            for (Person person : repository.findAll()) {
                System.out.println("Начислсли зарплату " + person.getLastName());
            }

        }
    }

    public static void main(String[] args) {
      /*  PersonRepository repository = new PersonRepository();

        PersonService service = new PersonService(repository);



        service.savePerson(new Person("Vasya", "Pupkin"));
        service.savePerson(new Person("Petya", "Pupkin"));


        SalaryService salaryService = new SalaryService(repository);


        System.out.println(service.findByLastName("Pupkin"));
        salaryService.sendSalary();*/
    }
}
