package com.example.daolayerhibernate.repository;

import com.example.daolayerhibernate.entity.Person;
import com.example.daolayerhibernate.entity.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonId> {
    List<Person> findByCityOfLiving(String city);
}