package Java_Day_01.ex03;

// Program.java (updated)
public class Program {
    public static void main(String[] args) {
        // ... (previous code)
        // Create users
        User user1 = new User(1, "John", 1000.0);
        User user2 = new User(2, "Alice", 1500.0);
        // User user3 = new User(3, "YASSINE", 500.0);

        // Create TransactionsLinkedList
        TransactionsList transactionsList = new TransactionsLinkedList();

        // Add transactions to the list
        Transaction transaction1 = new Transaction(user2, user1, "debit", 50.0);
        Transaction transaction2 = new Transaction(user1, user2, "credit", 30.0);

        transactionsList.addTransaction(transaction1);
        transactionsList.addTransaction(transaction2);

        // Display transactions in the list
        System.out.println("\nTransactions in the list:");
        for (Transaction transaction : transactionsList.toArray()) {
            System.out.println("Transaction ID: " + transaction.getIdentifier());
            System.out.println("Sender: " + transaction.getSender().getName());
            System.out.println("Recipient: " + transaction.getRecipient().getName());
            System.out.println("Transfer Category: " + transaction.getTransferCategory());
            System.out.println("Transfer Amount: " + transaction.getTransferAmount() + "\n");
        }

        // Remove a transaction by ID
        String transactionIdToRemove = transaction1.getIdentifier();
        transactionsList.removeTransactionById(transactionIdToRemove);
        System.out.println("Transaction removed with ID: " + transactionIdToRemove);

        // Display updated transactions in the list
        System.out.println("\nUpdated transactions in the list:");
        for (Transaction transaction : transactionsList.toArray()) {
            System.out.println("Transaction ID: " + transaction.getIdentifier());
            System.out.println("Sender: " + transaction.getSender().getName());
            System.out.println("Recipient: " + transaction.getRecipient().getName());
            System.out.println("Transfer Category: " + transaction.getTransferCategory());
            System.out.println("Transfer Amount: " + transaction.getTransferAmount() + "\n");
        }
    }
}