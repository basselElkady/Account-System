package edu.mum.cs.cs525.labs.exercises.project.creditcard.rule;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Account;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.AccountEntry;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.rule.EmailRule;

import java.math.BigDecimal;

public class CompanyAccountEmailRule implements EmailRule {
    @Override
    public void apply(Account account, String message, BigDecimal amount) {
        if (account.getAccountOwner() != null) {//todo: check CompanyAccount
            sendEmail(account, message, amount);
        }
    }

    private void sendEmail(Account account, String message, BigDecimal amount) {
        System.out.println(
                String.format("Sending email: account %s - %s ", account.getAccountNumber(), message) + amount + "$");
    }
}
