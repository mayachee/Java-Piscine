package Java_Day_01.ex02;

// Program.java
public class Program {
    public static void main(String[] args) {
        UsersList usersList = new UsersArrayList();

        // Adding users
        usersList.addUser(new User("Anna Doe"));
        usersList.addUser(new User("Yassine Ayache"));
        usersList.addUser(new User("Yassine Ayache"));
        usersList.addUser(new User("Yassine Ayache"));
        usersList.addUser(new User("Yassine Ayache"));
        usersList.addUser(new User("Yassine Ayache"));
        usersList.addUser(new User("Yassine Ayache"));
        usersList.addUser(new User("Yassine Ayache"));
        usersList.addUser(new User("Yassine Ayache"));

        // Retrieving and printing user information
        try {
            User userById = usersList.getUserById(5);
            System.out.println("User by ID: " + userById.getName());

            User userByIndex = usersList.getUserByIndex(0);
            System.out.println("User by Index: " + userByIndex.getName());

            System.out.println("Number of users: " + usersList.getNumberOfUsers());
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
