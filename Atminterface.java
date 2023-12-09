import java.util.Scanner;

class Atminterface {
    private double balance;

    public Atminterface(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    public static void main(String[] args) {
        // Set an initial balance for the bank account
        Atminterface account = new Atminterface(1000.0);

        // Create an ATM object with the user's bank account
        ATM atm = new ATM(account);

        // Start the ATM interface
        atm.startATM();
    }
}

class ATM {
    private Atminterface userAccount;
    private Scanner scanner;

    public ATM(Atminterface account) {
        this.userAccount = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        switch (option) {
            case 1:
                System.out.print("Enter withdrawal amount: $");
                double withdrawAmount = scanner.nextDouble();
                userAccount.withdraw(withdrawAmount);
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                userAccount.deposit(depositAmount);
                break;
            case 3:
                System.out.println("Current Balance: $" + userAccount.getBalance());
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }

    public void startATM() {
        int option;
        do {
            displayMenu();
            System.out.print("Enter your choice (1-4): ");
            option = scanner.nextInt();
            processOption(option);
        } while (option != 4);
        scanner.close();
    }
}


