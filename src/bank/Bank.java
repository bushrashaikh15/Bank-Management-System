package bank;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts = new ArrayList<>();

    // Create Account
    public void createAccount(Account account) {

        if (findAccount(account.getAccountNumber()) != null) {
            System.out.println("Account number already exists!");
            return;
        }

        accounts.add(account);
        System.out.println("Account created successfully.");
    }

    // Search Account
    public Account findAccount(int accountNumber) {

        for (Account account : accounts) {

            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }

        return null;
    }

    // Display All Accounts
    public void displayAllAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        for (Account account : accounts) {
            account.displayAccount();
        }
    }

    // Delete Account
    public void deleteAccount(int accountNumber) {

        Account account = findAccount(accountNumber);

        if (account != null) {
            accounts.remove(account);
            System.out.println("Account deleted successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    // Update Holder Name
    public void updateHolderName(int accountNumber, String newName) {

        Account account = findAccount(accountNumber);

        if (account != null) {
            account.setHolderName(newName);
            System.out.println("Name updated successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    // Transfer Money
    public void transferMoney(int fromAcc,
                              int toAcc,
                              double amount,
                              int pin) {

        Account sender = findAccount(fromAcc);
        Account receiver = findAccount(toAcc);

        if (sender == null || receiver == null) {
            System.out.println("Invalid account number.");
            return;
        }

        if (sender.getPin() != pin) {
            System.out.println("Incorrect PIN.");
            return;
        }

        if (sender.getBalance() < amount) {
            System.out.println("Insufficient balance.");
            return;
        }

        sender.withdraw(amount);
        receiver.deposit(amount);

        sender.addTransaction(
                "Transferred ₹" + amount +
                " to Account " + toAcc);

        receiver.addTransaction(
                "Received ₹" + amount +
                " from Account " + fromAcc);

        System.out.println("Money transferred successfully.");
    }
}