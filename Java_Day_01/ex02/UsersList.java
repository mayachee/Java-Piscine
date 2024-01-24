package Java_Day_01.ex02;

// UsersList.java
public interface UsersList {
    void addUser(User user);
    User getUserById(int userId);
    User getUserByIndex(int index);
    int getNumberOfUsers();
}
