package edu.mum.cs.cs525.labs.exercises.project.creditcard.entity;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.AccountType;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.InterestCalculationStrategy;
import edu.mum.cs.cs525.labs.exercises.project.creditcard.strategy.minimumPaymentStrategy.MinimumPaymentStrategy;

import java.time.LocalDate;

public abstract class CreditCardAccountType extends AccountType {

    private final MinimumPaymentStrategy minimumPaymentStrategy;


    protected CreditCardAccountType(InterestCalculationStrategy interestCalculationStrategy, MinimumPaymentStrategy minimumPaymentStrategy) {
        super(interestCalculationStrategy);
        this.minimumPaymentStrategy = minimumPaymentStrategy;
    }



    public LocalDate generateExpiryDate(){
        return LocalDate.now().plusYears(getCardValidityInYears()).withDayOfMonth(1);
    }



    protected abstract long getCardValidityInYears();

    public MinimumPaymentStrategy getMinimumPaymentStrategy() {
        return minimumPaymentStrategy;
    }
}
