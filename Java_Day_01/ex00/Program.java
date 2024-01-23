package Java_Day_00.ex00;

public class Program {
    public static void main(String[] args) {
        // Create users
        User user1 = new User(1, "John", 1000.0);
        User user2 = new User(2, "Alice", 1500.0);
        User user3 = new User(3, "YASSINE", 500.0);

        
        // Display user information
        System.out.println("User 1: " + user1.getName() + ", Balance: $" + user1.getBalance());
        System.out.println("User 2: " + user2.getName() + ", Balance: $" + user2.getBalance());
        System.out.println("User 3: " + user3.getName() + ", Balance: $" + user3.getBalance());
        
        // Create and display a transaction
        Transaction transaction = new Transaction(user2, user1, "debits", 500.0);
        
        displayTransactionDetails(transaction, user1, user2);
        
        // Create and display a transaction
        Transaction transaction1 = new Transaction(user3, user1, "test n yassine", 500.0);
        displayTransactionDetails(transaction1, user1, user3);
        System.out.println("\n The last Update Balances");
        System.out.println("User 1: " + user1.getName() + ", Balance: $" + user1.getBalance());
        System.out.println("User 2: " + user2.getName() + ", Balance: $" + user2.getBalance());
        System.out.println("User 3: " + user3.getName() + ", Balance: $" + user3.getBalance());

        System.out.println("\nEnd of Program");
    }

    public static void displayTransactionDetails(Transaction transaction, User UserSender, User UserRecipient) {
        System.out.println("-> Sender: " + transaction.getSender().getName());
        System.out.println("-> Recipient: " + transaction.getRecipient().getName());
        System.out.println("-> Transfer Category: " + transaction.getTransferCategory());
        System.out.println("-> Transfer Amount: $" + transaction.getTransferAmount());
    
        // Update user balances after the transaction
        UserSender.setBalance(UserSender.getBalance() - transaction.getTransferAmount());
        UserRecipient.setBalance(UserRecipient.getBalance() + transaction.getTransferAmount());
    
        // Display updated user balances
        System.out.println("\nUpdated Balances:");
        System.out.println("-> User Sender: " + UserSender.getName() + ", Balance: $" + UserSender.getBalance());
        System.out.println("-> User Recipient: " + UserRecipient.getName() + ", Balance: $" + UserRecipient.getBalance());
    
        System.out.println("\n-> End a Transaction");
    }
}
