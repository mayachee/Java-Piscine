package module00.ex00;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        // Initialize the six-digit integer
        // Create a Scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter six numbers
        System.out.println("Enter six numbers:");

        // Read the six numbers from the user
        int number = scanner.nextInt();
        
        // Calculate the sum of digits
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }

        // Display the result
        System.out.println("Sum of digits: " + sum);
    }
}