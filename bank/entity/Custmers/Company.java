package edu.mum.cs.cs525.labs.exercises.project.bank.entity.Custmers;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Customer;

public class Company extends Customer {
    private int NumberOfEmployees;
    public Company(String name, String email, String Street, String City, String State, String Zip, int NumberOfEmployee) {
        super(name, email, Street, City, State, Zip);
        this.NumberOfEmployees = NumberOfEmployee;
    }
    public int getNUmberOfEmployees() {
        return NumberOfEmployees;
    }

    public String getType() {
        return "COMPANY";
    }

}
