package Java_Day_01.ex04;

// TransactionsList.java
public interface TransactionsList {
    void addTransaction(Transaction transaction);
    void removeTransactionById(String transactionId);
    Transaction[] toArray();
}

