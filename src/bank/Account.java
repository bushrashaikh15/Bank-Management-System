package bank;

import java.util.ArrayList;

public class Account {

    private int accountNumber;
    private String holderName;
    private double balance;
    private int pin;
    private ArrayList<String> transactionHistory;

    public Account(int accountNumber, String holderName, double balance, int pin) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.pin = pin;
        this.transactionHistory = new ArrayList<>();

        transactionHistory.add("Account created with balance ₹" + balance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public int getPin() {
        return pin;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void deposit(double amount) {
        balance += amount;

        transactionHistory.add("Deposited ₹" + amount);

        System.out.println("₹" + amount + " deposited successfully.");
    }

    public void withdraw(double amount) {

        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;

            transactionHistory.add("Withdrawn ₹" + amount);

            System.out.println("₹" + amount + " withdrawn successfully.");
        }
    }

    public void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }

    public void displayTransactionHistory() {

        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        System.out.println("\nTransaction History:");

        for (String transaction : transactionHistory) {
            System.out.println("- " + transaction);
        }
    }

    public void displayAccount() {

        System.out.println("\nAccount Number : " + accountNumber);
        System.out.println("Holder Name    : " + holderName);
        System.out.println("Balance        : ₹" + balance);
    }
}