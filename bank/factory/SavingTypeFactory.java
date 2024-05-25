package edu.mum.cs.cs525.labs.exercises.project.bank.factory;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.AccountType;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.InterestCalculationStrategy;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.factory.AccountTypeFactory;
import edu.mum.cs.cs525.labs.exercises.project.bank.InteresetStrategy.SavingInterestStrategy;
import edu.mum.cs.cs525.labs.exercises.project.bank.entity.SavingsAccount;

public class SavingTypeFactory implements AccountTypeFactory {

    @Override
    public AccountType provide() {
        return new SavingsAccount(SavingInterestStrategy.getInstance());
    }
}
