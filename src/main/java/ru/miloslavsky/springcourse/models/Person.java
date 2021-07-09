package ru.miloslavsky.springcourse.models;

import javax.validation.constraints.*;

public class Person {
    private int id;
    @NotEmpty(message = "The field must not be empty")
    @Size(min = 3, max = 15, message = "Name length must be between 3-15 characters")
    private String name;
    @Min(value = 0, message = "Age cannot be negative")
    @Max(value = 150, message = "Age cannot be more than 150")
    private int age;
    @NotEmpty(message = "The field must not be empty")
    @Email(message = "Email must be valid")
    private String email;

    public Person() {

    }

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
