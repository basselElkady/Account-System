package edu.mum.cs.cs525.labs.exercises.project.bank.InteresetStrategy;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Account;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.InterestCalculationStrategy;

import java.math.BigDecimal;

public class CheckingAccountStrategy implements InterestCalculationStrategy {
    private static CheckingAccountStrategy checkingStrategy;
    private static final BigDecimal INTEREST_RATE = BigDecimal.valueOf(0.02);

    private CheckingAccountStrategy(){

    }

    @Override
    public BigDecimal calculateInterest(Account account) {
           return account.getBalance().multiply(INTEREST_RATE);
    }

    public static CheckingAccountStrategy getInstance(){
        if(checkingStrategy == null){
            checkingStrategy = new CheckingAccountStrategy();
        }
        return checkingStrategy;

    }

    public BigDecimal getRate() {
        return INTEREST_RATE;
    }
}


