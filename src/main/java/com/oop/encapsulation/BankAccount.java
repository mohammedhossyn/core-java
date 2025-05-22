package com.oop.encapsulation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccount {
    private final String accountNumber; // غیرقابل‌تغییر پس از تعریف
    private double balance;
    private List<Transaction> transactions; // تاریخچه تراکنش‌ها

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        transactions.add(new Transaction("Initial Deposit", initialBalance));
    }

    public synchronized void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
    }

    public synchronized void withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            throw new IllegalArgumentException("Invalid withdrawal amount");
        }
        balance -= amount;
        transactions.add(new Transaction("Withdrawal", -amount));
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactionHistory() {
        return Collections.unmodifiableList(transactions); // جلوگیری از تغییر تاریخچه
    }

    private static class Transaction {
        private final String type;
        private final double amount;
        private final LocalDateTime timestamp;

        Transaction(String type, double amount) {
            this.type = type;
            this.amount = amount;
            this.timestamp = LocalDateTime.now();
        }

        @Override
        public String toString() {
            return type + ": " + amount + " at " + timestamp;
        }
    }
}
