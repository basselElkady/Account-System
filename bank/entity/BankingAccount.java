package edu.mum.cs.cs525.labs.exercises.project.bank.entity;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.RandomGenerator;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Account;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.AccountType;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Customer;

public class BankingAccount extends Account {

    public BankingAccount(Customer accountOwner, AccountType accountType) {
        super(RandomGenerator.generateAccountNumber(), accountOwner, accountType);
    }

}
