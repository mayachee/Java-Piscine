package Java_Day_01.ex05;

// TransactionsList.java
public interface TransactionsList {
    void addTransaction(Transaction transaction);
    void removeTransactionById(String transactionId);
    Transaction[] toArray();
}

