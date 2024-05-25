package edu.mum.cs.cs525.labs.exercises.project.bank.factory;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.AccountType;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.factory.AccountTypeFactory;
import edu.mum.cs.cs525.labs.exercises.project.bank.InteresetStrategy.CheckingAccountStrategy;
import edu.mum.cs.cs525.labs.exercises.project.bank.entity.CheckingAccount;

public class CheckingTypeFactory implements AccountTypeFactory {

    @Override
    public AccountType provide() {
        return new CheckingAccount(CheckingAccountStrategy.getInstance());
    }
}
