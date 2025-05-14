abstract class Account {
    private String accountHolder;
    private int accountNumber;
    private double balance;

    public Account(String accountHolder, int accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }
    public String getAccountHolder() {
        return accountHolder;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    protected void setBalance(double balance) {
        this.balance = balance;
    }
    public abstract void deposit(double amount);
    public abstract void displayBalance();
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("Balance Amount: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
    public void withdraw(double amount, double fee) {
        double total = amount + fee;
        if (total <= balance) {
            balance -= total;
            System.out.println("Withdrawn: " + amount + " (Fee: "+fee+")");
            System.out.println("Balance Amount: " + balance);
        } else {
            System.out.println("Insufficient balance including fee!");
        }
    }
}
class BankAccount extends Account {
    public BankAccount(String accountHolder, int accountNumber) {
        super(accountHolder, accountNumber);
    }
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        System.out.println("Deposited: " + amount);
        System.out.println("Balance Amount: " + getBalance());
    }
    public void displayBalance() {
        System.out.println("---- Bank Account Details ----");
        System.out.println("Account Holder: " + getAccountHolder());
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Balance: " + getBalance());
    }
}
class SavingsAccount extends Account {
    public SavingsAccount(String accountHolder, int accountNumber) {
        super(accountHolder, accountNumber);
    }
    public void deposit(double amount) {
        double bonus = 0.02 * amount;
        setBalance(getBalance() + amount + bonus);
        System.out.println("Deposited: " + amount + " + Bonus: " + bonus);
        System.out.println("Balance Amount: " + getBalance());
    }
    public void displayBalance() {
        System.out.println("---- Savings Account Details ----");
        System.out.println("Account Holder: " + getAccountHolder());
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Balance: " + getBalance());
    }
}
public class Bank {
    public static void main(String[] args) {
        Account acc1 = new BankAccount("John Doe", 1001);
        Account acc2 = new SavingsAccount("Alice Smith", 2002);

        acc1.deposit(1000);
        System.out.println("******..............******");
        acc1.withdraw(300);
        System.out.println("******..............******");
        acc1.withdraw(100, 10);
        System.out.println("******..............******");
        acc1.displayBalance();
        System.out.println("******..............******");
        acc2.deposit(2000);
        System.out.println("******..............******");
        acc2.withdraw(500);
        System.out.println("******..............******");
        acc2.displayBalance();
        System.out.println("******..............******");
    }
}