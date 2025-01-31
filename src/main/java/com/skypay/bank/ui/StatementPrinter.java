package com.skypay.bank.ui;

import com.skypay.bank.domain.Transaction;
import java.util.List;

public class StatementPrinter {
    public void print(List<Transaction> transactions) {
        System.out.println("Date | Amount | Balance");
        for (Transaction t : transactions) {
            System.out.printf("%s | %d | %d%n", t.date(), t.amount(), t.balance());
        }
    }
}
