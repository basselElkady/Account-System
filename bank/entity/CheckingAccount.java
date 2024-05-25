package edu.mum.cs.cs525.labs.exercises.project.bank.entity;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.AccountType;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.InterestCalculationStrategy;

public class CheckingAccount extends AccountType {


    public CheckingAccount(InterestCalculationStrategy interestCalculationStrategy) {
        super(interestCalculationStrategy);
    }

}
