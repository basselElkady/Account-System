package edu.mum.cs.cs525.labs.exercises.project.creditcard.entity;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Customer;

import java.time.LocalDate;

public class Personal extends Customer {

    private final LocalDate birthDate;

    public Personal(String name, String email, String street, String city, String state, String zip, LocalDate birthDate) {
        super(name, email, street, city, state, zip);
        this.birthDate = birthDate;
    }

    public String getType() {
        return "PERSONAL";
    }
}
