package se.lexicon.dao.impl;

import se.lexicon.dao.PersonDAO;
import se.lexicon.dao.sequencer.PersonSequencer;
import se.lexicon.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDAOCollection implements PersonDAO {

    private List<Person> people;

    public PersonDAOCollection() {
        people = new ArrayList<>();
    }


    @Override
    public Person persist(Person person) {
        if (person == null) throw new IllegalArgumentException("Person is null");
        if (findByEmail(person.getEmail()) != null)
            throw new IllegalArgumentException("Email" + person.getEmail() + " is already used");
        person.setId(PersonSequencer.nextId());
        people.add(person);
        return person;
    }
    @Override
    public Person findById(int id) {
        if (id == 0) throw new IllegalArgumentException("Id is zero");
        return people.stream()

