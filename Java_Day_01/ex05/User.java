package Java_Day_01.ex05;

import java.util.UUID;

public class User {

    private UUID identifier;
    private int id;
    private String name;
    private double balance;
    private TransactionsList transactionsList;

    public User(UUID identifier,int id, String name, double balance) {
        this.id = id++;
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

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public UUID getIdentifier() {
            return identifier;
        }

        public void setIdentifier(UUID identifier) {
            this.identifier = identifier;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }
}
