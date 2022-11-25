package ru.danilin.spring.dao;

import org.springframework.stereotype.Component;
import ru.danilin.spring.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT,"Tom", "Male", "Tom@ya.ru" , 25));
        people.add(new Person(++PEOPLE_COUNT, "Bob", "Male", "Bob@ya.ru" , 52));
        people.add(new Person(++PEOPLE_COUNT,"Mike", "Male", "Mike@ya.ru" , 35));
        people.add(new Person(++PEOPLE_COUNT, "Katy", "Female", "Katy@ya.ru" , 18));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson) {
        Person personToBeUpdate = show(id);
        personToBeUpdate.setName(updatePerson.getName());
        personToBeUpdate.setSex(updatePerson.getSex());
        personToBeUpdate.setEmail(updatePerson.getEmail());
        personToBeUpdate.setAge(updatePerson.getAge());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }

}
