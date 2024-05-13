import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance > 0.0)
            balance = initialBalance;
    }

    public void credit(double amount) {
        balance += amount;
    }

    public boolean debit(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient funds.");
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class ATMMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(1000.0);
        int choice;
        double amount;

        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your current balance is: " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    amount = scanner.nextDouble();
                    if (account.debit(amount)) {
                        System.out.println("Amount withdrawn successfully.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the amount to deposit: ");
                    amount = scanner.nextDouble();
                    account.credit(amount);
                    System.out.println("Amount deposited successfully.");
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
