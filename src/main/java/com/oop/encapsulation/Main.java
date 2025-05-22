package com.oop.encapsulation;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345", 1000.0);
        account.deposit(500.0);
        account.withdraw(200.0);
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Transactions: " + account.getTransactionHistory());
    }
}