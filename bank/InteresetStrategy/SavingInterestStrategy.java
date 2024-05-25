package edu.mum.cs.cs525.labs.exercises.project.bank.InteresetStrategy;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Account;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.InterestCalculationStrategy;

import java.math.BigDecimal;

public class SavingInterestStrategy implements InterestCalculationStrategy {

    private static SavingInterestStrategy instance;
    private static final BigDecimal INTEREST_RATE = BigDecimal.valueOf(0.01);

    private SavingInterestStrategy() {

    }

    @Override
    public BigDecimal calculateInterest(Account account) {
        return account.getBalance().multiply(INTEREST_RATE);
    }

    public static SavingInterestStrategy getInstance() {
        if (instance == null) {
            instance = new SavingInterestStrategy();
        }
        return instance;
    }

    public BigDecimal getRate() {
        return INTEREST_RATE;
    }
}
