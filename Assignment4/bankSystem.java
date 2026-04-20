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
    static HashMap<Integer, Customer> customers = new HashMap<>();

    public static void main(String[] args) throws Exception {

        loadFromFile(); 

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

    // 🔹 Load all customers from file
    static void loadFromFile() throws Exception {
        File file = new File("account_holders.txt");
        if (!file.exists()) return;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(" ");
            int cid = Integer.parseInt(data[0]);
            String name = data[1];
            double balance = Double.parseDouble(data[2]);

            customers.put(cid, new Customer(cid, name, balance));
        }

        br.close();
    }

    
    static void saveToFile() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("account_holders.txt"));

        for (Customer c : customers.values()) {
            bw.write(c.cid + " " + c.name + " " + c.balance);
            bw.newLine();
        }

        bw.close();
    }

    static void createAccount() throws Exception {

        System.out.print("Enter CID (1-20): ");
        int cid = sc.nextInt();

        if (cid < 1 || cid > 20)
            throw new InvalidCIDException("CID must be between 1 and 20");

        if (customers.containsKey(cid))
            throw new InvalidCIDException("CID already exists");

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Initial Balance: ");
        double amount = sc.nextDouble();

        if (amount < 1000)
            throw new InvalidAmountException("Minimum balance is 1000");

        Customer c = new Customer(cid, name, amount);
        customers.put(cid, c);

        saveToFile(); 

        System.out.println("Account created successfully!");
    }
static void withdraw() throws Exception {

    // 🔹 Show available customers first (important UX fix)
    if (customers.isEmpty()) {
        throw new InvalidCIDException("No customers available");
    }

    System.out.println("\n--- Customer List ---");
    for (Customer c : customers.values()) {
        System.out.println("CID: " + c.cid + " | Name: " + c.name + " | Balance: " + c.balance);
    }

    // 🔹 Ask for CID
    System.out.print("Enter CID: ");
    int cid = sc.nextInt();

    if (!customers.containsKey(cid))
        throw new InvalidCIDException("Customer not found");

    Customer c = customers.get(cid);

    // 🔹 Ask withdrawal amount
    System.out.print("Enter withdrawal amount: ");
    double w_amt = sc.nextDouble();

    if (w_amt <= 0)
        throw new InvalidAmountException("Amount must be positive");

    if (w_amt > c.balance)
        throw new InsufficientBalanceException("Insufficient balance");

  
    c.balance -= w_amt;

 
    saveToFile();

    System.out.println("Withdrawal successful!");
    System.out.println("Remaining balance: " + c.balance);
}
}
