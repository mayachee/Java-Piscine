package Java_Day_01.ex04;

import java.util.UUID;

public interface UsersList {
    void addUser(User user);
    User getUserById(UUID userId);
    User[] toArray();
}
