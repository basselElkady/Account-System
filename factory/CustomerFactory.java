package edu.mum.cs.cs525.labs.exercises.project.accountparty.factory;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Customer;

public interface CustomerFactory {

    Customer createCustomer(String name, String email, String street, String city, String state, String zip);

}
