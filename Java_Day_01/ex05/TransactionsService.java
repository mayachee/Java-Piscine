package Java_Day_01.ex05;


import java.util.ArrayList;
// import java.util.Arrays;
import java.util.List;
import java.util.UUID;

// TransactionsService.java
public class TransactionsService {
    private UsersList usersList;

    public TransactionsService(UsersList usersList) {
        this.usersList = usersList;
    }

    public void addUser(User user) {
        usersList.addUser(user);
    }

    public double getUserBalance(int userId) {
        UUID UUID_ID = null;
        for (User user : usersList.toArray()) {
            if (user.getId() == userId) {
                UUID_ID = user.getIdentifier();
            }
        }
        User user = usersList.getUserById(UUID_ID);
        return user.getBalance();
    }

    public void removeTransactionByIdForUser(int userId, String transactionId) {
        UUID UUID_ID = null;
        for (User user : usersList.toArray()) {
            if (user.getId() == userId) {
                UUID_ID = user.getIdentifier();
            }
        }
        User user = usersList.getUserById(UUID_ID);
        user.getTransactionsList().removeTransactionById(transactionId);
    }

    public void performTransfer(int senderId, int recipientId, double transferAmount) {
        UUID senderUUID = null;
        UUID recipientUUID = null;
        for (User user : usersList.toArray()) {
            if (user.getId() == senderId) {
                senderUUID = user.getIdentifier();
            } else if (user.getId() == recipientId) {
                recipientUUID = user.getIdentifier();
            }
        }
        User sender = usersList.getUserById(senderUUID);
        User recipient = usersList.getUserById(recipientUUID);

        if (transferAmount > sender.getBalance()) {
            throw new IllegalTransactionException("Insufficient balance for transfer");
        }

        Transaction debitTransaction = new Transaction(recipient, sender, "debit", transferAmount);
        Transaction creditTransaction = new Transaction(sender, recipient, "credit", transferAmount);

        recipient.getTransactionsList().addTransaction(debitTransaction);
        sender.getTransactionsList().addTransaction(creditTransaction);
    }

    public Transaction[] getUserTransfers(UUID userId) {
        User user = usersList.getUserById(userId);
        return user.getTransactionsList().toArray();
    }

    public Transaction[] checkValidityOfTransactions() {
        List<Transaction> unpairedTransactions = new ArrayList<>();
    
        for (User user : usersList.toArray()) {
            for (Transaction transaction : user.getTransactionsList().toArray()) {
                if (!hasOppositeTransaction(user, transaction)) {
                    unpairedTransactions.add(transaction);
                }
            }
        }
    
        return unpairedTransactions.toArray(new Transaction[0]);
    }
    
    private boolean hasOppositeTransaction(User user, Transaction transaction) {
        String oppositeType = transaction.getTransferCategory().equals("debit") ? "credit" : "debit";
        User oppositeUser = transaction.getTransferCategory().equals("debit") ? transaction.getSender() : transaction.getRecipient();
    
        for (Transaction oppositeTransaction : oppositeUser.getTransactionsList().toArray()) {
            if (oppositeTransaction.getTransferCategory().equals(oppositeType)
                    && oppositeTransaction.getTransferAmount() == transaction.getTransferAmount()) {
                return true;
            }
        }
    
        return false;
    }

    public Transaction[] checkTransferValidity() {
        return checkValidityOfTransactions();

        // Implementation remains the same, assuming it works with UUIDs
    }
    public void viewAllTransactions(int userId) {
        UUID UUID_ID = null;
        for (User user : usersList.toArray()) {
            if (user.getId() == userId) {
                UUID_ID = user.getIdentifier();
            }
        }
        User user = usersList.getUserById(UUID_ID);
        for (Transaction transaction : user.getTransactionsList().toArray()) {
            System.out.println("Transaction ID: " + transaction.getIdentifier());
            System.out.println("Transfer Amount: " + transaction.getTransferAmount());
        }
    }

}