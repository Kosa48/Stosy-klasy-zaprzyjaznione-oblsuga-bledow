import bank.*;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Kamila Krecinosek", 64);
        BankManager manager = new BankManager();

        manager.printBalance(account);
    }
}
