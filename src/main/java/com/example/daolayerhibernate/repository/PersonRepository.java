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

    @Query(value = "SELECT * FROM PERSONS WHERE city_of_living = :city", nativeQuery = true)
    List<Person> findByCityOfLiving(@Param("city") String city);

    @Query(value = "SELECT * FROM PERSONS WHERE age < :age ORDER BY age ASC", nativeQuery = true)
    List<Person> findByAgeLessThanOrderByAgeAsc(@Param("age") Integer age);

    @Query(value = "SELECT * FROM PERSONS WHERE name = :name AND surname = :surname AND age = :age", nativeQuery = true)
    Optional<Person> findByNameAndSurnameAndAge(
            @Param("name") String name,
            @Param("surname") String surname,
            @Param("age") Integer age
    );

    @Query(value = "SELECT * FROM PERSONS WHERE name = :name AND surname = :surname", nativeQuery = true)
    List<Person> findByNameAndSurname(
            @Param("name") String name,
            @Param("surname") String surname
    );
}