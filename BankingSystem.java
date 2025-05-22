import java.util.*;

abstract class BankAccount {
    String accountNumber;
    String holderName;
    double balance;

    BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    abstract double calculateInterest();

    void deposit(int amount) {
        balance += amount;
    }

    void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient Balance....");
        }
    }

    void displayBalance() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + holderName);
        System.out.println("Available Balance : " + balance);
        System.out.println("Calculated Interest : " + calculateInterest());
    }
}

class SavingsAccount extends BankAccount {
    SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    double calculateInterest() {
        return balance * 0.04;
    }
}

class CurrentAccount extends BankAccount {
    CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    double calculateInterest() {
        return balance * 0.02;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("12345", "Alice", 10000);
        BankAccount current = new CurrentAccount("12345", "Alice", 10000);
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Your Account Type :\n1.Savings Account\n2.Current Account");
        int ACchoice = sc.nextInt();

        switch (ACchoice) {
            case 1: {
                System.out.println("Enter Your Choice :\n1.Withdraw Amount\n2.Deposit Amount\n3.Display Balance");
                int Choice = sc.nextInt();
                switch (Choice) {
                    case 1: {
                        System.out.println("Enter Amount : ");
                        int amount = sc.nextInt();
                        savings.withdraw(amount);
                        savings.displayBalance();
                        break;
                    }
                    case 2: {
                        System.out.println("Enter Amount : ");
                        int amount = sc.nextInt();
                        savings.deposit(amount);
                        savings.displayBalance();
                        break;
                    }
                    case 3: {
                        savings.displayBalance();
                        break;
                    }
                }
                break;
            }
            case 2: {
                System.out.println("Enter Your Choice :\n1.Withdraw Amount\n2.Deposit Amount\n3.Display Balance");
                int Choice = sc.nextInt();
                switch (Choice) {
                    case 1: {
                        System.out.println("Enter Amount : ");
                        int amount = sc.nextInt();
                        current.withdraw(amount);
                        current.displayBalance();
                        break;
                    }
                    case 2: {
                        System.out.println("Enter Amount : ");
                        int amount = sc.nextInt();
                        current.deposit(amount);
                        current.displayBalance();
                        break;
                    }
                    case 3: {
                        current.displayBalance();
                        break;
                    }
                }
                break;
            }
        }
    }
}
