package edu.mum.cs.cs525.labs.exercises.project.accountparty.notification;

import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.Account;
import edu.mum.cs.cs525.labs.exercises.project.accountparty.entity.AccountEntry;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TransactionObservable {
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Account account, String message, BigDecimal amount) {
        for (Observer observer : observers) {
            observer.send(account, message, amount);
        }
    }
}
