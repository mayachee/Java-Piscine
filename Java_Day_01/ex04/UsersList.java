package Java_Day_01.ex04;

public interface UsersList {
    void addUser(User user);
    User getUserById(int userId);
    User[] toArray();
}
