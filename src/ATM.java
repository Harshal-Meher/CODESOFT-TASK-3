import java.util.Scanner;

import java.util.Scanner;

public class ATM {

    private Scanner scanner;
    private BankAccount account;

    public ATM() 
    {
        scanner = new Scanner(System.in);
        account = new BankAccount();
    }

    public void withdraw() 
    {
        System.out.println("Enter the amount to withdraw:");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive amount.");
        } else if (amount > account.getBalance()) {
            System.out.println("Insufficient balance. Please enter a smaller amount.");
        } else {
            account.setBalance(account.getBalance() - amount);
            System.out.println("You have successfully withdrawn " + amount + " from your account.");
            System.out.println("Your current balance is " + account.getBalance() + ".");
        }
    }

    public void deposit() 
    {
        System.out.println("Enter the amount to deposit:");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive amount.");
        }
        else 
        {
            account.setBalance(account.getBalance() + amount);
            System.out.println("You have successfully deposited " + amount + " to your account.");
            System.out.println("Your current balance is " + account.getBalance() + ".");
        }
    }

    public void checkBalance() {
        System.out.println("Your current balance is " + account.getBalance() + ".");
    }

    public void displayMenu()
    {
        System.out.println("Welcome to the ATM machine!");
        System.out.println("Please choose an option:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check balance");
        System.out.println("4. Exit");
    }

    public void performOption(int option) 
    {
        switch (option) 
        {
            case 1:
                withdraw();
                break;
            case 2:
                deposit();
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                System.out.println("Thank you for using the ATM machine!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }


   
    public static void main(String[] args) 
    {
        ATM atm = new ATM();

        while (true) 
        {
            atm.displayMenu();
            System.out.println("Enter your option:");
            int option = atm.scanner.nextInt();
            atm.performOption(option);
        }
    }
}

class BankAccount {

    private double balance;

    public BankAccount() {
        balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
