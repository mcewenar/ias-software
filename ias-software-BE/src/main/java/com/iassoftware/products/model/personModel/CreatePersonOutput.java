package com.iassoftware.products.model.personModel;

import com.iassoftware.products.domain.personDomain.Person;

import java.time.LocalDate;

public class CreatePersonOutput {
    private Person person;

    public CreatePersonOutput() {
    }

    public CreatePersonOutput(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
