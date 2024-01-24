package Java_Day_01.ex04;


import java.util.ArrayList;
// import java.util.Arrays;
import java.util.List;

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
        User user = usersList.getUserById(userId);
        return user.getBalance();
    }

    public void performTransfer(int senderId, int recipientId, double transferAmount) {
        User sender = usersList.getUserById(senderId);
        User recipient = usersList.getUserById(recipientId);

        if (transferAmount > sender.getBalance()) {
            throw new IllegalTransactionException("Insufficient balance for transfer");
        }

        Transaction debitTransaction = new Transaction(recipient, sender, "debit", transferAmount);
        Transaction creditTransaction = new Transaction(sender, recipient, "credit", transferAmount);

        recipient.getTransactionsList().addTransaction(debitTransaction);
        sender.getTransactionsList().addTransaction(creditTransaction);
    }

    public Transaction[] getUserTransfers(int userId) {
        User user = usersList.getUserById(userId);
        return user.getTransactionsList().toArray();
    }

    public void removeTransactionByIdForUser(int userId, String transactionId) {
        User user = usersList.getUserById(userId);
        user.getTransactionsList().removeTransactionById(transactionId);
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

}