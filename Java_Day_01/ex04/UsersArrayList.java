package Java_Day_01.ex04;

// UsersArrayList.java (updated)
import java.util.Arrays;
import java.util.UUID;

public class UsersArrayList implements UsersList {
    private static final int DEFAULT_CAPACITY = 10;
    private User[] users;
    private int size;

    public UsersArrayList() {
        this.users = new User[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public void addUser(User user) {

        if (size == users.length) {
            users = Arrays.copyOf(users, users.length * 3 / 2); // Increase array size by half
        }
        users[size++] = user;
    }

    @Override
    public User getUserById(UUID userId) {
        for (User user : users) {
            if (user != null && user.getIdentifier() == userId) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found with ID: " + userId);
    }

    @Override
    public User[] toArray() {
        return Arrays.copyOf(users, size);
    }
}