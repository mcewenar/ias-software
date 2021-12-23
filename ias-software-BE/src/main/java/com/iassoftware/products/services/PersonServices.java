package com.iassoftware.products.services;

import com.iassoftware.products.domain.personDomain.Person;
import com.iassoftware.products.domain.personDomain.PersonId;
import com.iassoftware.products.repository.personRepository.PersonsRepository;

import java.util.List;

public class PersonServices {
    private PersonsRepository repository;

    public PersonServices(PersonsRepository repository) {
        this.repository = repository;
    }


    public List<Person> listPersons() {
        return repository.list();
    }


    public Person createPerson(Person person) {
        repository.create(person);
        return person;
    }


    public Person getPerson(PersonId personId) {
        return repository.findOne(personId);
    }


    public void deletePerson(PersonId personId) {
        repository.delete(personId);
    }


    public Person updatePerson(PersonId personId, Person person) {
        repository.update(personId, person);

        return repository.findOne(personId);
    }
}
