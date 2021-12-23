package com.iassoftware.products.controllers;

import com.iassoftware.products.domain.personDomain.Person;
import com.iassoftware.products.domain.personDomain.PersonId;
import com.iassoftware.products.domain.personDomain.PersonName;
import com.iassoftware.products.model.personModel.CreatePersonInput;
import com.iassoftware.products.model.personModel.CreatePersonOutput;
import com.iassoftware.products.model.personModel.UpdatePersonInput;
import com.iassoftware.products.model.personModel.UpdatePersonOutput;
import com.iassoftware.products.services.PersonServices;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

public class PersonController {
    private final PersonServices services;

    public PersonController(PersonServices services) {
        this.services = services;
    }

    @GetMapping
    public List<Person> listPersons() {
        return services.listPersons();
    }

    @PostMapping
    public CreatePersonOutput createPerson(@RequestBody CreatePersonInput input) {
        PersonName personName = new PersonName(input.getName());
        LocalDate birthday = input.getBirthday();
        PersonId random = PersonId.random();
        Person person = new Person(random, personName, birthday);
        Person createdPerson = services.createPerson(person);

        return new CreatePersonOutput(createdPerson);
    }


    @GetMapping(value = "/{id}")
    public Person getPerson(@PathVariable("id") String personId) {
        final PersonId id = PersonId.fromString(personId);
        return services.getPerson(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePerson(@PathVariable("id") String personId) {
        final PersonId id = PersonId.fromString(personId);
        services.deletePerson(id);
    }

    @PutMapping(value = "/{id}")
    public UpdatePersonOutput updatePerson(@PathVariable("id") String unsafeId, @RequestBody UpdatePersonInput input) {
        final PersonId id = PersonId.fromString(unsafeId);
        Person newPerson = new Person(id, new PersonName(input.getName()), input.getBirthday());
        final Person updated = services.updatePerson(id, newPerson);
        return new UpdatePersonOutput(updated);
    }

}
