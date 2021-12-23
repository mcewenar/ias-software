package com.iassoftware.products.model.personModel;

import com.iassoftware.products.domain.personDomain.Person;

public class UpdatePersonOutput {
    private Person person;

    public UpdatePersonOutput() {
    }

    public UpdatePersonOutput(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
