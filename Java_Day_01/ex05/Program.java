package Java_Day_01.ex05;

// Program.java
public class Program {
    public static void main(String[] args) {
        boolean devMode = false;
        for (String arg : args) {
            if (arg.equals("--profile=dev")) {
                devMode = true;
                break;
            }
        }

        UsersList usersList = new UsersArrayList();
        TransactionsService transactionsService = new TransactionsService(usersList);
        Menu menu = new Menu(transactionsService, devMode);
        menu.displayMenu();
    }
}
