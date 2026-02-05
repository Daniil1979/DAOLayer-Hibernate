package com.example.daolayerhibernate.controller;

import com.example.daolayerhibernate.entity.Person;
import com.example.daolayerhibernate.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secure")
public class SecureController {

    private final PersonRepository personRepository;

    @Autowired
    public SecureController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/read")
    @Secured("ROLE_READ")
    public List<Person> getAllForRead() {
        return personRepository.findAll();
    }

    @GetMapping("/write")
    @Secured("ROLE_WRITE")
    public List<Person> getAllForWrite() {
        return personRepository.findAll();
    }

    @GetMapping("/edit")
    @PreAuthorize("hasRole('WRITE') or hasRole('DELETE')")
    public List<Person> getAllForEdit() {
        return personRepository.findAll();
    }

    @GetMapping("/user")
    @PreAuthorize("#username == authentication.name")
    public String getUserData(@RequestParam String username) {
        return "Данные пользователя: " + username;
    }
}