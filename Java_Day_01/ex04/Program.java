package Java_Day_01.ex04;

// Program.java
public class Program {
    public static void main(String[] args) {
        // Create TransactionsService with UsersArrayList
        UsersList usersList = new UsersArrayList();
        TransactionsService transactionsService = new TransactionsService(usersList);

        // Add users to the system
        User user1 = new User(1, "John Doe", 100.0);
        User user2 = new User(2, "Jane Doe", 150.0);
        transactionsService.addUser(user1);
        transactionsService.addUser(user2);

        // Display user balances in red
        System.out.println("\u001B[31mUser 1 Balance: " + transactionsService.getUserBalance(user1.getIdentifier()) + "\u001B[0m");
        System.out.println("\u001B[31mUser 2 Balance: " + transactionsService.getUserBalance(user2.getIdentifier()) + "\u001B[0m");


        // Perform a transfer
        transactionsService.performTransfer(user1.getIdentifier(), user2.getIdentifier(), 100.0);

        // Display updated user balances
        System.out.println("\nUpdated User Balances:");
        System.out.println("User 1 Balance: " + transactionsService.getUserBalance(user1.getIdentifier()));
        System.out.println("User 2 Balance: " + transactionsService.getUserBalance(user2.getIdentifier()));

        // Display user transfers
        System.out.println("\nUser 1 Transfers:");
        Transaction[] user1Transfers = transactionsService.getUserTransfers(user1.getIdentifier());
        for (Transaction transaction : user1Transfers) {
            System.out.println("Transaction ID: " + transaction.getIdentifier());
            System.out.println("Transfer Amount: " + transaction.getTransferAmount());
        }

        // Remove a transaction by ID for a specific user
        transactionsService.removeTransactionByIdForUser(user1.getIdentifier(), user1Transfers[0].getIdentifier());
        System.out.println("\nUser 1 Transfers (after removal):");
        for (Transaction transaction : transactionsService.getUserTransfers(user1.getIdentifier())) {
            System.out.println("Transaction ID: " + transaction.getIdentifier());
            System.out.println("Transfer Amount: " + transaction.getTransferAmount());
        }

        // Check validity of transactions
        System.out.println("\nUnpaired Transactions:");
        Transaction[] unpairedTransactions = transactionsService.checkValidityOfTransactions();
        for (Transaction transaction : unpairedTransactions) {
            System.out.println("Transaction ID: " + transaction.getIdentifier());
            System.out.println("Transfer Amount: " + transaction.getTransferAmount());
        }

        // Display updated user balances
        System.out.println("\u001B[33m\nUpdated User Balances:");
        System.out.println("User 1 Balance: " + transactionsService.getUserBalance(user1.getIdentifier()) + ", Identifier: " + user1.getIdentifier());
        System.out.println("User 2 Balance: " + transactionsService.getUserBalance(user2.getIdentifier()) + ", Identifier: " + user2.getIdentifier() + "\u001B[0m");

    }
}
