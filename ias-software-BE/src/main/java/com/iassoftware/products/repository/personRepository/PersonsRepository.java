package com.iassoftware.products.repository.personRepository;

import com.iassoftware.products.domain.personDomain.Person;
import com.iassoftware.products.domain.personDomain.PersonId;

import java.util.List;

public interface PersonsRepository {
    List<Person> list();

    Person findOne(PersonId id);

    void create(Person person);

    void update(PersonId id, Person person);

    void delete(PersonId id);
}
