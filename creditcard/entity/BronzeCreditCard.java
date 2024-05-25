package edu.mum.cs.cs525.labs.exercises.project.creditcard.entity;

import edu.mum.cs.cs525.labs.exercises.project.creditcard.strategy.interestStrategy.BronzeCreditCardInterestCalculationStrategy;
import edu.mum.cs.cs525.labs.exercises.project.creditcard.strategy.minimumPaymentStrategy.BronzeMinimumPaymentStrategy;

public class BronzeCreditCard extends CreditCardAccountType {


    public BronzeCreditCard() {
        super(new BronzeCreditCardInterestCalculationStrategy(), new BronzeMinimumPaymentStrategy());
    }



    @Override
    protected long getCardValidityInYears() {
        return 2;
    }
}
