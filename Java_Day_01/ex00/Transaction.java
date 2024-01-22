package Java_Day_01.ex00;

import java.util.UUID;

public class Transaction {
    private UUID identifier;
    private User recipient;
    private User sender;
    private String transferCategory;
    private double transferAmount;

    public Transaction(User recipient, User sender, String transferCategory, double transferAmount) {
        this.identifier = UUID.randomUUID();
        this.recipient = recipient;
        this.sender = sender;
        this.transferCategory = transferCategory;
        this.transferAmount = transferAmount;
    }

    // Getters
    public UUID getIdentifier() {
        return identifier;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }

    public String getTransferCategory() {
        return transferCategory;
    }

    public double getTransferAmount() {
        return transferAmount;
    }
}
