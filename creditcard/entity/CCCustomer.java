package edu.mum.cs.cs525.labs.exercises.project.creditcard.entity;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Customer;

public class CCCustomer extends Customer {

    public CCCustomer(String name, String email, String street, String city, String state, String zip) {
        super(name, email, street, city, state, zip);
    }

    public String getType() {
        return "CREDITCARD";
    }
}
