package edu.mum.cs.cs525.labs.exercises.project.creditcard.entity;

import edu.mum.cs.cs525.labs.exercises.project.creditcard.strategy.interestStrategy.GoldCreditCardInterestCalculationStrategy;
import edu.mum.cs.cs525.labs.exercises.project.creditcard.strategy.minimumPaymentStrategy.GoldMinimumPaymentStrategy;

public class GoldCreditCard extends CreditCardAccountType {


    public GoldCreditCard() {
        super(new GoldCreditCardInterestCalculationStrategy(), new GoldMinimumPaymentStrategy());
    }



    @Override
    protected long getCardValidityInYears() {
        return 4;
    }
}
