package edu.mum.cs.cs525.labs.exercises.project.creditcard.entity;

import edu.mum.cs.cs525.labs.exercises.project.creditcard.strategy.interestStrategy.SilverCreditCardInterestCalculationStrategy;
import edu.mum.cs.cs525.labs.exercises.project.creditcard.strategy.minimumPaymentStrategy.SilverMinimumPaymentStrategy;

public class SilverCreditCard extends CreditCardAccountType {


    public SilverCreditCard() {
        super(new SilverCreditCardInterestCalculationStrategy(), new SilverMinimumPaymentStrategy());
    }



    @Override
    protected long getCardValidityInYears() {
        return 3;
    }
}
