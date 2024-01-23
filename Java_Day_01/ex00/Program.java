package Java_Day_01.ex00;

public class Program {
    public static void main(String[] args) {
        // Create users
        User user1 = new User(1, "John", 1000.0);
        User user2 = new User(2, "Alice", 1500.0);

        // Display user information
        System.out.println("User 1: " + user1.getName() + ", Balance: $" + user1.getBalance());
        System.out.println("User 2: " + user2.getName() + ", Balance: $" + user2.getBalance());

        // Create and display a transaction
        Transaction transaction = new Transaction(user2, user1, "debits", 500.0);
        System.out.println("\nTransaction ID: " + transaction.getIdentifier());
        System.out.println("Sender: " + transaction.getSender().getName());
        System.out.println("Recipient: " + transaction.getRecipient().getName());
        System.out.println("Transfer Category: " + transaction.getTransferCategory());
        System.out.println("Transfer Amount: $" + transaction.getTransferAmount());

        // Update user balances after the transaction
        user1.setBalance(user1.getBalance() - transaction.getTransferAmount());
        user2.setBalance(user2.getBalance() + transaction.getTransferAmount());

        // Display updated user balances
        System.out.println("\nUpdated Balances:");
        System.out.println("User 1: " + user1.getName() + ", Balance: $" + user1.getBalance());
        System.out.println("User 2: " + user2.getName() + ", Balance: $" + user2.getBalance());
    }
}
