

import java.util.Locale;
import java.util.ResourceBundle;
import java.text.MessageFormat;
import java.util.Date;

public class LocalizationExample {

    public static void main(String[] args) {
        // Optional: Set the desired locale (comment out for default)
        Locale locale = Locale.US;

        // Load the resource bundle (uses default locale if not specified)
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);

        // Get localized messages
        String greeting = bundle.getString("greeting");
        String goodbye = bundle.getString("goodbye");
        String name = bundle.getString("name");

        // Display the localized messages
        System.out.println(greeting);
        System.out.println(goodbye);
        System.out.println(name);

        // Define the message pattern with placeholders
        String pattern = "Today is {0,date,short} and the temperature is {1,number,#.##} degrees Celsius.";

        // Prepare the arguments for the message
        Date today = new Date();
        double temperature = 25.5;

        // Format the message using MessageFormat
        String formattedMessage = MessageFormat.format(pattern, today, temperature);

        // Print the formatted message
        System.out.println(formattedMessage); 
    }
}
