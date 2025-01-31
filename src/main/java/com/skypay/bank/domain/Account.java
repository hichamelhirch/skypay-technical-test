package com.skypay.bank.domain;

import com.skypay.bank.infrastructure.DateProvider;
import com.skypay.bank.service.AccountService;
import com.skypay.bank.ui.StatementPrinter;

import java.util.ArrayList;
import java.util.List;

public class Account implements AccountService {
    private final List<Transaction> transactions = new ArrayList<>();
    private int balance = 0;
    private final DateProvider dateProvider;
    private final StatementPrinter statementPrinter;

    public Account(DateProvider dateProvider, StatementPrinter statementPrinter) {
        this.dateProvider = dateProvider;
        this.statementPrinter = statementPrinter;
    }
    // Dépôt d'argent
    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Le montant doit être positif.");
        }
        balance += amount;
        transactions.add(new Transaction(dateProvider.getCurrentDate(), amount, balance));
    }
    // Retrait d'argent
    @Override
    public void withdraw(int amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Solde insuffisant.");
        }
        balance -= amount;
        transactions.add(new Transaction(dateProvider.getCurrentDate(), -amount, balance));
    }
    // Imprime le relevé bancaire
    @Override
    public void printStatement() {
        statementPrinter.print(transactions);
    }
}
