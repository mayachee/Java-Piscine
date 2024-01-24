package Java_Day_01.ex02;

// Program.java
public class Program {
    public static void main(String[] args) {
        // Create users
        User user1 = new User(1, "John Doe", 100.0);
        User user2 = new User(2, "Jane Doe", 150.0);

        // Display user information
        System.out.println("User 1: " + user1.getName() + " - Balance: " + user1.getBalance());
        System.out.println("User 2: " + user2.getName() + " - Balance: " + user2.getBalance());

        // Create a transaction
        Transaction transaction = new Transaction(user2, user1, "debit", 50.0);

        // Display transaction information
        System.out.println("\nTransaction ID: " + transaction.getIdentifier());
        System.out.println("Sender: " + transaction.getSender().getName());
        System.out.println("Recipient: " + transaction.getRecipient().getName());
        System.out.println("Transfer Category: " + transaction.getTransferCategory());
        System.out.println("Transfer Amount: " + transaction.getTransferAmount());
    }
}
