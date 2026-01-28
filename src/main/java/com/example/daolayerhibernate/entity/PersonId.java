package com.example.daolayerhibernate.entity;

import java.io.Serializable;
import java.util.Objects;

public class PersonId implements Serializable {

    private String name;
    private String surname;
    private Integer age;

    public PersonId() {}

    public PersonId(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public Integer getAge() { return age; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonId personId = (PersonId) o;
        return Objects.equals(name, personId.name) &&
                Objects.equals(surname, personId.surname) &&
                Objects.equals(age, personId.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }
}