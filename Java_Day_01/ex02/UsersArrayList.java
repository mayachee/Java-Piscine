package Java_Day_01.ex02;

import java.util.Arrays;

// UsersArrayList.java
public class UsersArrayList implements UsersList {
    private static final int DEFAULT_CAPACITY = 10;
    private User[] users;
    private int size;

    public UsersArrayList() {
        this.users = new User[DEFAULT_CAPACITY];
        this.size = 0;
    }

    private void ensureCapacity() {
        if (size == users.length) {
            users = Arrays.copyOf(users, users.length + (users.length / 2));
        }
    }

    @Override
    public void addUser(User user) {
        ensureCapacity();
        users[size++] = user;
    }

    @Override
    public User getUserById(int userId) throws UserNotFoundException {
        for (User user : users) {
            if (user != null && user.getId() == userId) {
                return user;
            }
        }
        throw new UserNotFoundException("User with ID " + userId + " not found");
    }

    @Override
    public User getUserByIndex(int index) throws UserNotFoundException {
        if (index >= 0 && index < size) {
            return users[index];
        }
        throw new UserNotFoundException("User at index " + index + " not found");
    }

    @Override
    public int getNumberOfUsers() {
        return size;
    }
}
