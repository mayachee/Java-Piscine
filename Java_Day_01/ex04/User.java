package Java_Day_01.ex04;

import java.util.UUID;

public class User {

    private UUID identifier;
    private String name;
    private double balance;
    private TransactionsList transactionsList;

    public User(int identifier, String name, double balance) {
        this.identifier = UUID.randomUUID();
        this.name = name;
        this.balance = balance;
        this.transactionsList = new TransactionsLinkedList();
    }
    // ... (previous methods)

    public TransactionsList getTransactionsList() {
        return transactionsList;
    }

    // Getters
    public UUID getIdentifier() {
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
