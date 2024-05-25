package edu.mum.cs.cs525.labs.exercises.project.accountparty.notification;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Account;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.AccountEntry;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.rule.RulesEngine;

import java.math.BigDecimal;

public class EmailSender implements Observer {

    private final RulesEngine rulesEngine;
    private static EmailSender INSTANCE;

    private EmailSender(RulesEngine rulesEngine) {
        this.rulesEngine = rulesEngine;
    }

    public static EmailSender getInstance(RulesEngine rulesEngine) {
        if (INSTANCE == null) {
            INSTANCE = new EmailSender(rulesEngine);
        }
        return INSTANCE;
    }

    @Override
    public void send(Account account, String message, BigDecimal amount) {
        rulesEngine.applyRules(account, message, amount);
    }
}
