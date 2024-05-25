package edu.mum.cs.cs525.labs.exercises.project.accountparty.notification;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Account;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.AccountEntry;

import java.math.BigDecimal;

public interface Observer {
    void send(Account account, String message, BigDecimal amount);
}
