package bank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {

            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Search Account");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Delete Account");
            System.out.println("7. Update Holder Name");
            System.out.println("8. Check Balance");
            System.out.println("9. Transfer Money");
            System.out.println("10. View Transaction History");
            System.out.println("11. Exit");

            System.out.print("Enter your choice: ");

            try {

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1 -> {
                        System.out.print("Account Number: ");
                        int accNo = Integer.parseInt(sc.nextLine());

                        System.out.print("Holder Name: ");
                        String name = sc.nextLine();

                        System.out.print("Initial Balance: ");
                        double balance = Double.parseDouble(sc.nextLine());

                        System.out.print("Set 4-digit PIN: ");
                        int pin = Integer.parseInt(sc.nextLine());

                        bank.createAccount(
                                new Account(accNo, name, balance, pin));
                    }

                    case 2 -> {
                        System.out.print("Account Number: ");
                        int accNo = Integer.parseInt(sc.nextLine());

                        Account account = bank.findAccount(accNo);

                        if (account != null) {

                            System.out.print("Amount: ");
                            double amount =
                                    Double.parseDouble(sc.nextLine());

                            account.deposit(amount);

                        } else {
                            System.out.println("Account not found.");
                        }
                    }

                    case 3 -> {
                        System.out.print("Account Number: ");
                        int accNo = Integer.parseInt(sc.nextLine());

                        Account account = bank.findAccount(accNo);

                        if (account != null) {

                            System.out.print("PIN: ");
                            int pin =
                                    Integer.parseInt(sc.nextLine());

                            if (account.getPin() == pin) {

                                System.out.print("Amount: ");
                                double amount =
                                        Double.parseDouble(sc.nextLine());

                                account.withdraw(amount);

                            } else {
                                System.out.println("Invalid PIN.");
                            }

                        } else {
                            System.out.println("Account not found.");
                        }
                    }

                    case 4 -> {
                        System.out.print("Account Number: ");
                        int accNo = Integer.parseInt(sc.nextLine());

                        Account account = bank.findAccount(accNo);

                        if (account != null) {
                            account.displayAccount();
                        } else {
                            System.out.println("Account not found.");
                        }
                    }

                    case 5 -> bank.displayAllAccounts();

                    case 6 -> {
                        System.out.print("Account Number: ");
                        int accNo = Integer.parseInt(sc.nextLine());

                        bank.deleteAccount(accNo);
                    }

                    case 7 -> {
                        System.out.print("Account Number: ");
                        int accNo = Integer.parseInt(sc.nextLine());

                        System.out.print("New Holder Name: ");
                        String newName = sc.nextLine();

                        bank.updateHolderName(accNo, newName);
                    }

                    case 8 -> {
                        System.out.print("Account Number: ");
                        int accNo = Integer.parseInt(sc.nextLine());

                        Account account = bank.findAccount(accNo);

                        if (account != null) {

                            System.out.print("PIN: ");
                            int pin =
                                    Integer.parseInt(sc.nextLine());

                            if (account.getPin() == pin) {

                                System.out.println(
                                        "Current Balance: ₹"
                                        + account.getBalance());

                            } else {
                                System.out.println("Invalid PIN.");
                            }

                        } else {
                            System.out.println("Account not found.");
                        }
                    }

                    case 9 -> {
                        System.out.print("From Account: ");
                        int from =
                                Integer.parseInt(sc.nextLine());

                        System.out.print("PIN: ");
                        int pin =
                                Integer.parseInt(sc.nextLine());

                        System.out.print("To Account: ");
                        int to =
                                Integer.parseInt(sc.nextLine());

                        System.out.print("Amount: ");
                        double amount =
                                Double.parseDouble(sc.nextLine());

                        bank.transferMoney(
                                from, to, amount, pin);
                    }

                    case 10 -> {
                        System.out.print("Account Number: ");
                        int accNo =
                                Integer.parseInt(sc.nextLine());

                        Account account =
                                bank.findAccount(accNo);

                        if (account != null) {

                            System.out.print("PIN: ");
                            int pin =
                                    Integer.parseInt(sc.nextLine());

                            if (account.getPin() == pin) {

                                account.displayTransactionHistory();

                            } else {
                                System.out.println("Invalid PIN.");
                            }

                        } else {
                            System.out.println("Account not found.");
                        }
                    }

                    case 11 -> {
                        System.out.println("Thank you!");
                        sc.close();
                        return;
                    }

                    default ->
                            System.out.println("Invalid choice.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter valid input.");
            }
        }
    }
}