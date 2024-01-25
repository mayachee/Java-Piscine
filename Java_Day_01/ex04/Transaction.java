package Java_Day_01.ex04;

import java.util.UUID;

public class Transaction {
    private String identifier;
    private User recipient;
    private User sender;
    private String transferCategory;
    private double transferAmount;

    public Transaction(User recipient, User sender, String transferCategory, double transferAmount) {
        this.identifier = UUID.randomUUID().toString();
        this.recipient = recipient;
        this.sender = sender;
        this.transferCategory = transferCategory;
        this.transferAmount = transferAmount;
    }

    public String getIdentifier() {
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
