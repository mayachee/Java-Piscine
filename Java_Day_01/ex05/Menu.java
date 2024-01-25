package Java_Day_01.ex05;

import java.util.Scanner;
import java.util.UUID;

// import javax.xml.crypto.dsig.TransformService;

// import java.util.ArrayList;

// Menu.java
public class Menu {
    private int id = 0;

    private TransactionsService transactionsService;
    private boolean devMode;

    public Menu(TransactionsService transactionsService, boolean devMode) {
        this.transactionsService = transactionsService;
        this.devMode = devMode;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add a user");
            System.out.println("2. View user balances");
            System.out.println("3. Perform a transfer");
            System.out.println("4. View all transactions for a specific user");
            if (devMode) {
                System.out.println("5. DEV - remove a transfer by ID");
                System.out.println("6. DEV - check transfer validity");
            }
            System.out.println("7. Finish execution");

            System.out.print("-> ");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        addUser(scanner);
                        break;
                    case 2:
                        viewUserBalances(scanner);
                        break;
                    case 3:
                        performTransfer(scanner);
                        break;
                    case 4:
                        viewAllTransactions(scanner);
                        break;
                    case 5:
                        if (devMode) removeTransactionByIdForUser(scanner);
                        break;
                    case 6:
                        if (devMode) checkTransferValidity();
                        break;
                    case 7:
                        System.out.println("$> Finished execution");
                        return;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Consume newline character
            }
        }
    }
    private void addUser(Scanner scanner) {
        System.out.print("Enter a user name and a balance -> ");
        String name = scanner.next();
        double balance = scanner.nextDouble();

        User user = new User(UUID.randomUUID(), id, name, balance);
        transactionsService.addUser(user);
        System.out.println("User with id = " + user.getId() + " is added ---------------------------------------------------------");
        id++;
    }

    private void viewUserBalances(Scanner scanner) {
        System.out.print("Enter a user ID -> ");
        int userId = scanner.nextInt();
        double balance = transactionsService.getUserBalance(userId);
        System.out.println(transactionsService.getUserBalance(userId) + " - " + balance);
    }

    private void performTransfer(Scanner scanner) {
        System.out.print("Enter a sender ID, a recipient ID, and a transfer amount -> ");
        // UUID senderId = scanner.nextInt();
        // UUID recipientId = scanner.nextInt();
        int senderId = scanner.nextInt();
        int recipientId = scanner.nextInt();
        double transferAmount = scanner.nextDouble();
        transactionsService.performTransfer(senderId, recipientId, transferAmount);
        System.out.println("The transfer is completed ---------------------------------------------------------");
    }

    private void viewAllTransactions(Scanner scanner) {
        System.out.print("Enter a user ID -> ");
        int userId = scanner.nextInt();
        transactionsService.viewAllTransactions(userId);
    }

    private void removeTransactionByIdForUser(Scanner scanner) {
        System.out.print("Enter a user ID and a transfer ID -> ");
        int userId = scanner.nextInt();
        String transferId = scanner.next(); 
        transactionsService.removeTransactionByIdForUser(userId, transferId);
        System.out.println("Transfer removed");
    }

    private void checkTransferValidity() {
        transactionsService.checkTransferValidity();
    }
}
