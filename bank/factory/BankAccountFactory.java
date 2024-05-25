package edu.mum.cs.cs525.labs.exercises.project.bank.factory;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Account;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Customer;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.factory.AccountFactory;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.factory.AccountTypeFactory;
import edu.mum.cs.cs525.labs.exercises.project.bank.entity.BankingAccount;

public class BankAccountFactory implements AccountFactory {

    @Override
    public Account createNewAccountForCustomer(Customer customer, AccountTypeFactory accountTypeFactory) {
        return new BankingAccount(customer, accountTypeFactory.provide());
    }
}
