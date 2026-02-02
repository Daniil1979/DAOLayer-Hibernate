package com.example.daolayerhibernate.repository;

import com.example.daolayerhibernate.entity.Person;
import com.example.daolayerhibernate.entity.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonId> {

    @Query("SELECT p FROM Person p WHERE p.cityOfLiving = :city")
    List<Person> findByCityOfLiving(@Param("city") String city);  // ← важно: именно так!

    @Query("SELECT p FROM Person p WHERE p.age < :age ORDER BY p.age ASC")
    List<Person> findByAgeLessThanOrderByAgeAsc(@Param("age") Integer age);

    @Query("SELECT p FROM Person p WHERE p.name = :name AND p.surname = :surname AND p.age = :age")
    Optional<Person> findByNameAndSurnameAndAge(
            @Param("name") String name,
            @Param("surname") String surname,
            @Param("age") Integer age
    );

    @Query("SELECT p FROM Person p WHERE p.name = :name AND p.surname = :surname")
    List<Person> findByNameAndSurname(
            @Param("name") String name,
            @Param("surname") String surname
    );
}