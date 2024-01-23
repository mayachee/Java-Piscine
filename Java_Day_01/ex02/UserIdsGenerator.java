package Java_Day_01.ex02;

// UserIdsGenerator.java
public class UserIdsGenerator {
    private static UserIdsGenerator instance;
    private int lastGeneratedId;

    private UserIdsGenerator() {
        // Private constructor to prevent instantiation outside this class
        lastGeneratedId = 0;
    }

    public static UserIdsGenerator getInstance() {
        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }

    public int generateId() {
        return ++lastGeneratedId;
    }
}
