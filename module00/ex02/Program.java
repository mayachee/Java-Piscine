package module00.ex02;
import java.util.Scanner;

// Example of program operation:
// $> java Program
// -> 198131
// -> 12901212
// -> 11122
// -> 42
// Count of coffee-request : 2
// $>

public class Program {
    public static void main(String[] args) {

        System.out.println("13 is break");

        // Create a Scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Counter for coffee-related queries
        int coffeeCount = 0;

        // Process queries until the input is 13
        while (true) {
            // Prompt the user to enter a query
            System.out.print("-> ");
            
            // Check if the input is 42 (termination condition)
            if (scanner.hasNextInt() == false)
                System.out.println("Invalid input. Please enter a valid integer.");

            if (scanner.hasNextInt()) {
                int query = scanner.nextInt();
                // Check if the input is 13, if so, break out of the loop
                if (query == 13) {
                    break;
                }

                // Check if the sum of digits is a prime number
                if (isPrime(sumOfDigits(query))) {
                    coffeeCount++;
                }
            } else {
                // If input is not an integer, consume the invalid input
                scanner.next();
            }
        }

        // Display the count of coffee-related queries
        System.out.println("Count of coffee-request: " + coffeeCount);

        // Close the Scanner to prevent resource leak
        scanner.close();
    }
    // Function to calculate the sum of digits of a number
    private static int sumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    // Function to check if a number is prime
    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

