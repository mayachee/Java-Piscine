package Random_Idea;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {
    public static void main(String[] args) {
        try {
                // Create a URI object with the URL of the website
                    URI uri = new URI("https://unsplash.com/");

            // Convert the URI to a URL
            URL url = uri.toURL();
            // Open a connection to the URL
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            conn.setRequestMethod("GET");

            // Get the input stream from the connection
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            // Create a FileWriter and BufferedWriter to write text data to a file
            FileWriter textFileWriter = new FileWriter("website_text.txt");
            BufferedWriter textWriter = new BufferedWriter(textFileWriter);

            // Create a file to save images
            File imageFolder = new File("images");
            imageFolder.mkdir();

            String inputLine;
            StringBuilder htmlContent = new StringBuilder();

            // Read the response line by line and append to the StringBuilder
            while ((inputLine = in.readLine()) != null) {
                htmlContent.append(inputLine);
            }

            // Close the input stream
            in.close();

            // Extract text using regular expressions and write to the text file
            String textContent = extractText(htmlContent.toString());
            textWriter.write(textContent);

            // Extract image URLs using regular expressions and print them
            extractAndSaveImages(htmlContent.toString(), imageFolder);

            // Close writers
            textWriter.close();
            textFileWriter.close();

            System.out.println("Data has been extracted and written to files.");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to extract text content from HTML using regular expressions
    private static String extractText(String htmlContent) {
        // Regular expression to remove HTML tags
        String textOnly = htmlContent.replaceAll("<[^>]*>", "");
        return textOnly;
    }

    // Method to extract image URLs from HTML using regular expressions and save them
    private static void extractAndSaveImages(String htmlContent, File imageFolder) {
        // Regular expression to find image tags
        Pattern pattern = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
        Matcher matcher = pattern.matcher(htmlContent);

        // Find all image tags and save images
        while (matcher.find()) {
            String imageUrl = matcher.group(1);
            saveImage(imageUrl, imageFolder);
        }
    }

    // Method to save image from URL to a folder
    private static void saveImage(String imageUrl, File imageFolder) {

        try {
            // Create a URI object with the URL of the website
            try {
                URI uri = new URI(imageUrl);

                // Convert the URI to a URL
                URL url = uri.toURL();
                String fileName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
                File imageFile = new File(imageFolder, fileName);

                // Open connection to the image URL
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                // Read from connection's input stream and write to file output stream
                try (InputStream inputStream = conn.getInputStream();
                     FileOutputStream outputStream = new FileOutputStream(imageFile)) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }
                System.out.println("Image saved: " + imageFile.getAbsolutePath());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
