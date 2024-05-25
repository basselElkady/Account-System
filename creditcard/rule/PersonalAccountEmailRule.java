package edu.mum.cs.cs525.labs.exercises.project.creditcard.rule;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Account;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.AccountEntry;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.rule.EmailRule;

import java.math.BigDecimal;

public class PersonalAccountEmailRule implements EmailRule {
    private final BigDecimal threshold = BigDecimal.valueOf(400);
    @Override
    public void apply(Account account, String message, BigDecimal amount) {
        if (account.getAccountOwner() != null) {//todo: check PersonalAccount
            String emailMessage = "";
            if(amount.compareTo(threshold) > 0) {
                emailMessage = String.format("Account %s - The %s amount was larger than ", account.getAccountNumber(), message) + threshold + "$";
            } else {
                emailMessage = String.format("Account %s - Balance is less than 0", account.getAccountNumber());
            }
            sendEmail(account, emailMessage, amount);
        }
    }

    private void sendEmail(Account account, String message, BigDecimal amount) {
        System.out.println("Sending email: " + message);

    }
}
