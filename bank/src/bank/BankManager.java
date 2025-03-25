package bank;

public class BankManager {
    public void printBalance(BankAccount account) {
        System.out.println(account.getOwner()+ " Saldo " + account.getBalance() + " PLN");
    }
}