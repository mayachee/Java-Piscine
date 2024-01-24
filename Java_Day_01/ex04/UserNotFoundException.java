package Java_Day_01.ex04;

// UserNotFoundException.java
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}