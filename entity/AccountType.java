package edu.mum.cs.cs525.labs.exercises.project.accountparty.entity;

public abstract class AccountType {

    private InterestCalculationStrategy interestCalculationStrategy;


    protected AccountType(InterestCalculationStrategy interestCalculationStrategy) {
        this.interestCalculationStrategy = interestCalculationStrategy;
    }


    public InterestCalculationStrategy getInterestCalculationStrategy() {
        return interestCalculationStrategy;
    }

}
