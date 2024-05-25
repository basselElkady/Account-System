package edu.mum.cs.cs525.labs.exercises.project.bank.ServiceLayer.Implmentation;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Customer;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.repository.CustomerRepository;
import edu.mum.cs.cs525.labs.exercises.project.bank.ServiceLayer.CustmerService;
import edu.mum.cs.cs525.labs.exercises.project.bank.entity.Custmers.Company;
import edu.mum.cs.cs525.labs.exercises.project.bank.entity.Custmers.Person;

import java.time.LocalDate;

public class CustomerService implements CustmerService {

    CustomerRepository CustomerRepository;
    public CustomerService() {
        this.CustomerRepository = new CustomerRepository();
    }


    @Override
    public Company CreateCustmer(String name, String email, String Street, String City, String State, String Zip, int NumberOfEmployee) {
        Company company = new Company(name, email, Street, City, State, Zip, NumberOfEmployee);
        CustomerRepository.save(company);

        return company;
    }

    @Override
    public Person CreateCustmer(String name, String email, String Street, String City, String State, String Zip, LocalDate dateOfBirth) {
        Person person = new Person(name, email, Street, City, State, Zip, dateOfBirth);
        CustomerRepository.save(person);
        return person;
    }
}
