package Java_Day_01.ex02;

import java.util.UUID;

// UsersList.java
public interface UsersList {
    void addUser(User user);
    User getUserById(UUID userId);
    User getUserByIndex(int index);
    int getNumberOfUsers();
}
