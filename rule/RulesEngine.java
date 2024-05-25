package edu.mum.cs.cs525.labs.exercises.project.accountparty.rule;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Account;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.AccountEntry;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RulesEngine {
    private final List<EmailRule> emailRules;

    public RulesEngine() {
        this.emailRules = new ArrayList<>();
    }

    public void addRule(EmailRule emailRule) {
        emailRules.add(emailRule);
    }

    public void applyRules(Account account, String message, BigDecimal amount) {

        for (EmailRule rule : emailRules) {
            rule.apply(account, message, amount);
        }
    }
}
