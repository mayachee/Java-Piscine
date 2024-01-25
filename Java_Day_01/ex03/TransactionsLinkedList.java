package Java_Day_01.ex03;

// TransactionsLinkedList.java
public class TransactionsLinkedList implements TransactionsList {
    private TransactionNode head;
    private int size;

    private static class TransactionNode {
        Transaction transaction;
        TransactionNode next;

        TransactionNode(Transaction transaction) {
            this.transaction = transaction;
        }
    }

    @Override
    public void addTransaction(Transaction transaction) {
        TransactionNode newNode = new TransactionNode(transaction);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public void removeTransactionById(String transactionId) {
        TransactionNode current = head;
        TransactionNode prev = null;

        while (current != null && !current.transaction.getIdentifier().equals(transactionId)) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            throw new TransactionNotFoundException("Transaction not found with ID: " + transactionId);
        }

        if (prev == null) {
            // If the first node needs to be removed
            head = current.next;
        } else {
            prev.next = current.next;
        }

        size--;
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] transactionsArray = new Transaction[size];
        TransactionNode current = head;

        for (int i = 0; i < size; i++) {
            transactionsArray[i] = current.transaction;
            current = current.next;
        }

        return transactionsArray;
    }
}
