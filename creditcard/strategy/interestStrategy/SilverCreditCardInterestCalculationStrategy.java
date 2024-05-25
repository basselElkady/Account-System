package edu.mum.cs.cs525.labs.exercises.project.creditcard.strategy.interestStrategy;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Account;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.InterestCalculationStrategy;
import java.math.BigDecimal;

public class SilverCreditCardInterestCalculationStrategy implements InterestCalculationStrategy {
    private static final BigDecimal INTEREST_RATE = BigDecimal.valueOf(0.08);
    @Override
    public BigDecimal calculateInterest(Account account) {
        BigDecimal rate = new BigDecimal("0.08");
        return account.getBalance().multiply(rate);
    }
    public BigDecimal getRate() {
        return INTEREST_RATE;
    }
}
