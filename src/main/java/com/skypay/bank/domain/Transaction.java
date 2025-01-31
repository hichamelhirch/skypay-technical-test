package com.skypay.bank.domain;

public class Transaction {
    private final String date;
    private final int amount;
    private final int balance;

    public Transaction(String date, int amount, int balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public String date() { return date; }
    public int amount() { return amount; }
    public int balance() { return balance; }
}
