package edu.mum.cs.cs525.labs.exercises.project.accountparty.notification;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Account;

import java.math.BigDecimal;

public interface Observable {
    void add(String eventType, Observer o);

    void remove(String eventType, Observer o);

    void notifyObservers(String notificationType, Account account, String message, BigDecimal amount);
}
