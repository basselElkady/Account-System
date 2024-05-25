package edu.mum.cs.cs525.labs.exercises.project.accountparty.service.statehandler;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Account;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ClosedAccountStateHandler implements AccountStateHandler {

    @Override
    public void deposit(BigDecimal amount) {
        throw new IllegalStateException("Deposit is not allowed on a closed account");
    }



    @Override
    public void withdraw(BigDecimal amount) {
        throw new IllegalStateException("Withdrawal is not allowed on a closed account");
    }



    @Override
    public void addInterest() {
        throw new IllegalStateException("Interest is not allowed on a closed account");
    }



    @Override
    public void transferFunds(Account toAccount, BigDecimal amount) {
        throw new IllegalStateException("Funds Transfer is not allowed on a closed account");
    }


    @Override
    public void closeAccount() {
        throw new IllegalStateException("Account is already closed");
    }

}
