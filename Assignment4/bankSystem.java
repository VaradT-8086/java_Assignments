import java.io.*;
import java.util.*;


class InvalidCIDException extends Exception {
    InvalidCIDException(String msg) {
        super(msg);
    }
}

class InvalidAmountException extends Exception {
    InvalidAmountException(String msg) {
        super(msg);
    }
}

class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String msg) {
        super(msg);
    }
}

class Customer {
    int cid;
    String name;
    double balance;

    Customer(int cid, String name, double balance) {
        this.cid = cid;
        this.name = name;
        this.balance = balance;
    }
}


public class bankSystem {

    static Scanner sc = new Scanner(System.in);
    static Customer customer = null;

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n--- Banking System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Withdraw");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        createAccount();
                        break;

                    case 2:
                        withdraw();
                        break;

                    case 3:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 3);
    }

   
    static void createAccount() throws Exception {

        System.out.print("Enter CID (1-20): ");
        int cid = sc.nextInt();

        if (cid < 1 || cid > 20)
            throw new InvalidCIDException("CID must be between 1 and 20");

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Initial Balance: ");
        double amount = sc.nextDouble();

        if (amount <= 0)
            throw new InvalidAmountException("Amount must be positive");

        if (amount < 1000)
            throw new InvalidAmountException("Minimum balance is 1000");

        customer = new Customer(cid, name, amount);

        FileWriter fw = new FileWriter("customers.txt", true);
        fw.write(cid + " " + name + " " + amount + "\n");
        fw.close();

        System.out.println("Account created successfully!");
    }

  
    static void withdraw() throws Exception {

        if (customer == null) {
            System.out.println("No account found. Create account first.");
            return;
        }

        System.out.print("Enter withdrawal amount: ");
        double w_amt = sc.nextDouble();

        if (w_amt > customer.balance)
            throw new InsufficientBalanceException("Insufficient balance");

        customer.balance -= w_amt;

        System.out.println("Withdrawal successful!");
        System.out.println("Remaining balance: " + customer.balance);
    }
}


































