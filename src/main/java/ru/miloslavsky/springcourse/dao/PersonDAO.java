package ru.miloslavsky.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.miloslavsky.springcourse.models.Person;

import java.util.List;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        Object[] args = {id};
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", args,
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void save(Person person) {
        Object[] args = {person.getName(), person.getAge(), person.getEmail()};
        jdbcTemplate.update("INSERT INTO Person(name, age, email) VALUES(?, ?, ?)", args);
    }

    public void update(int id, Person person) {
        Object[] args = {person.getName(), person.getAge(), person.getEmail(), id};
        jdbcTemplate.update("UPDATE Person SET name=?, age=?, email=? WHERE id=?", args);
    }

    public void delete(int id) {
        Object[] args = {id};
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", args);
    }
}
