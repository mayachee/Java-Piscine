

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormattingExample {

    public static void main(String[] args) {
        // Get current date and time
        LocalDateTime now = LocalDateTime.now();

        // Define different format patterns
        String pattern1 = "yyyy-MM-dd HH:mm:ss"; // Example: 2024-07-05 15:30:45
        String pattern2 = "MM/dd/yyyy h:mm a";     // Example: 07/05/2024 3:30 PM
        String pattern3 = "EEEE, MMMM d, yyyy";    // Example: Friday, July 5, 2024

        // Create DateTimeFormatter objects
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern(pattern1);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern(pattern2);
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern(pattern3);

        // Format the date and time using different patterns
        String formattedDateTime1 = now.format(formatter1);
        String formattedDateTime2 = now.format(formatter2);
        String formattedDateTime3 = now.format(formatter3);

        // Print the formatted strings
        System.out.println("Formatted Date/Time 1: " + formattedDateTime1);
        System.out.println("Formatted Date/Time 2: " + formattedDateTime2);
        System.out.println("Formatted Date/Time 3: " + formattedDateTime3);
    }
}