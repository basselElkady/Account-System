package edu.mum.cs.cs525.labs.exercises.project.accountparty.factory;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Account;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Customer;

public interface AccountFactory {

    Account createNewAccountForCustomer(Customer customer, AccountTypeFactory accountTypeFactory);
}
