package bank;

public class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public String getOwner() { 
        return owner;
    }

    public double getBalance() { 
        return balance;
    }
}
