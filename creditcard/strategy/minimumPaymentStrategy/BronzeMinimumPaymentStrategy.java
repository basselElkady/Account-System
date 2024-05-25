package edu.mum.cs.cs525.labs.exercises.project.creditcard.strategy.minimumPaymentStrategy;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Account;

import java.math.BigDecimal;

public class BronzeMinimumPaymentStrategy implements MinimumPaymentStrategy{
    private static final BigDecimal RATE = BigDecimal.valueOf(0.14);
    @Override
    public BigDecimal minimumPayment(Account account) {
        BigDecimal mp = new BigDecimal("0.14");
        return account.getBalance().add(account.getBalance().multiply(mp));
    }
    public BigDecimal getRate() {
        return RATE;
    }
}
