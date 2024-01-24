package Java_Day_01.ex03;

// TransactionNotFoundException.java
public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException(String message) {
        super(message);
    }
}
