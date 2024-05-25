package edu.mum.cs.cs525.labs.exercises.project.creditcard.service;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Customer;

public interface CustomerService {

    public Customer createCustomer(String name, String email, String street, String city, String state, String zip);
}
