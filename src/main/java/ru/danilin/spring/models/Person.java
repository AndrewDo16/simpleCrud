package ru.danilin.spring.models;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.*;

public class Person {
    private int id;
    @NotNull(message = "Name must not be empty")
    @Size (min = 2, max = 30, message = "The name must not be less than 2 and not more than 30 characters")
    private String name;
    @NotNull(message = "The Gender field must not be empty")
    private String sex;
    @NotNull(message = "Email must not be empty")
    @Email(message = "Not correct Email")
    private String email;
    @Min(value = 0, message = "Enter correct age")
    @Max(value = 120, message = "Enter correct age")
    private int age;

    public Person() {

    }

    public Person(int id, String name, String sex, String email, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
