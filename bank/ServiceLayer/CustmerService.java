package edu.mum.cs.cs525.labs.exercises.project.bank.ServiceLayer;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Customer;

import java.time.LocalDate;

public interface CustmerService {

    Customer CreateCustmer(String name, String email, String Street, String City, String State, String Zip, int NumberOfEmployee);
    Customer CreateCustmer(String name, String email, String Street, String City, String State, String Zip, LocalDate dateOfBirth);

}
