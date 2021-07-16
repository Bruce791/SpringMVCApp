package ru.miloslavsky.springcourse.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.miloslavsky.springcourse.models.Person;

import java.util.List;

import static org.junit.Assert.*;

public class PersonDAOTest {
    private PersonDAO personDAO;

    @Before
    public void setUp() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/first_db");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");

        personDAO = new PersonDAO(new JdbcTemplate(dataSource));
    }

    @Test
    public void index() {
        List<Person> people = personDAO.index();

        assertFalse(people.isEmpty());
    }

    @Test
    public void show() {
        int id = 12;
        Person person = personDAO.show(id);

        assertNotNull(person);
    }

    @Test
    public void save() {
        Person person = new Person(1, "Vasya", 22, "vasya@mail.ru");
        personDAO.save(person);
    }

    @Test
    public void update() {
        int id = 12;
        Person person = personDAO.show(id);
        person.setName("Jhon");
        person.setAge(35);
        person.setEmail("jhony@mail.ru");

        personDAO.update(id, person);
    }

    @Test
    public void delete() {
        int id = 13;
        personDAO.delete(id);
    }
}