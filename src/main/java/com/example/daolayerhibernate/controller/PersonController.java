package com.example.daolayerhibernate.controller;

import com.example.daolayerhibernate.entity.Person;
import com.example.daolayerhibernate.entity.PersonId;
import com.example.daolayerhibernate.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personRepository.findByCityOfLiving(city);
    }

    @GetMapping("/younger-than")
    public List<Person> getPersonsYoungerThan(@RequestParam Integer age) {
        return personRepository.findByAgeLessThanOrderByAgeAsc(age);
    }

    @GetMapping("/find")
    public Optional<Person> getPersonByNameAndSurname(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam Integer age) {
        return personRepository.findByNameAndSurnameAndAge(name, surname, age);
    }

    @GetMapping("/find-any")
    public List<Person> getPersonsByNameAndSurname(
            @RequestParam String name,
            @RequestParam String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }
}