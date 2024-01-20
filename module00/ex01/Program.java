import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        // Create a Scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        try{
            // Prompt the user to enter a number
            System.out.print("-> ");
            int number = scanner.nextInt();
            // Check for negative numbers, 0, and 1
            if (number <= 1) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }

            // Check if the number is prime
            boolean isPrime = true;
            int iterations = 0;

            for (int i = 2; i <= Math.sqrt(number); i++) {
                iterations++;
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            // Display the result and the number of iterations
            System.out.println("- result: " + isPrime + " " + iterations);
        }
        catch (InputMismatchException e) {
            System.err.println("Invalid input. Please enter a valid integer.");
        } finally {
            // Close the Scanner to prevent resource leak
            scanner.close();
        }
    }
}
