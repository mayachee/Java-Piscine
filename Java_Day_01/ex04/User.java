package Java_Day_01.ex04;

public class User {
    private int identifier;
    private String name;
    private double balance;
    private TransactionsList transactionsList;

    public User(int identifier, String name, double balance) {
        this.identifier = identifier;
        this.name = name;
        this.balance = balance;
        this.transactionsList = new TransactionsLinkedList();
    }

    // ... (previous methods)

    public TransactionsList getTransactionsList() {
        return transactionsList;
    }

    // Getters and setters
    public int getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
