package ru.miloslavsky.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.miloslavsky.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Jack", 25, "jack@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Amy", 20, "amy@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Julia", 23, "julia@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Paul", 29, "paul@mail.ru"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        for (Person person : people) {
            if (person.getId() == id)
                return person;
        }
        return null;
    }

    public void save(Person person) {
        people.add(person);
    }

    public void update(int id, Person person) {
        Person updatePerson = show(id);
        updatePerson.setName(person.getName());
        updatePerson.setAge(person.getAge());
        updatePerson.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
