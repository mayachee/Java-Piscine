package Random_Idea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class Program {
    public static void main(String[] args) {
        try {
            // Create a URL object with the URL of the website
            URI uri = new URI("https://abbasimusab2000.medium.com/react-js-with-emailjs-62aec5fb66df");
            URL url = uri.toURL();

            // Open a connection to the URL
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            conn.setRequestMethod("GET");

            // Get the input stream from the connection
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            // Create a FileWriter and BufferedWriter to write data to a file
            FileWriter fileWriter = new FileWriter("website_data.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);

            // Read the response line by line and write to the file
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                writer.write(inputLine);
                writer.newLine(); // Add newline character for each line
            }

            // Close the input stream and the file writer
            in.close();
            writer.close();

            System.out.println("Data has been written to website_data.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
