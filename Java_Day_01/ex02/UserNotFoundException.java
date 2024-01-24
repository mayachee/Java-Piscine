package Java_Day_01.ex02;

// UserNotFoundException.java
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}