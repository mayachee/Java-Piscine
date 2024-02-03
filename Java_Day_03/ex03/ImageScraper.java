package Java_Day_03.ex03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageScraper {
    public static void main(String[] args) {
        String urlString = "https://unsplash.com"; // Specify the URL of the website here
        String outputFile = "image_urls.txt"; // Specify the name of the output file

        try {
            // Create a URI object
            URI websiteUri = new URI(urlString);

            // Open a connection to the website
            HttpURLConnection connection = (HttpURLConnection) websiteUri.toURL().openConnection();

            // Set request method
            connection.setRequestMethod("GET");

            // Create a BufferedReader to read the HTML content
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            // Pattern to match image URLs in the HTML content
            Pattern pattern = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");

            // Create a BufferedWriter to write URLs to the output file
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            // Read each line of the HTML content
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                // Match the pattern against each line
                Matcher matcher = pattern.matcher(inputLine);
                while (matcher.find()) {
                    // Write the matched image URL to the output file
                    if (matcher.group(1).startsWith("http") || matcher.group(1).startsWith("https")) {
                        writer.write(matcher.group(1));
                        writer.newLine();
                    }
                }
            }

            // Close the BufferedReader and BufferedWriter
            in.close();
            writer.close();

            System.out.println("Image URLs written to: " + outputFile);

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}

