package org.example.splitwise.models;

public class Amount {
    private final Currency currency;
    private double balance;

    public Amount(Currency currency, double balance) {
        this.currency = currency;
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }


}
