package Random_Idea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractLinksFromFile {

    public static List<String> extractLinks(String filePath) {
        List<String> links = new ArrayList<>();

        // Define the regex pattern to match URLs
        String urlPattern = "http[s]?://(?:[a-zA-Z]|[0-9]|[$-_@.&+]|[!*\\\\(\\\\),]|(?:%[0-9a-fA-F][0-9a-fA-F]))+";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            Pattern pattern = Pattern.compile(urlPattern);

            // Read lines from the file and search for URLs
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    links.add(matcher.group());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return links;
    }

    public static void main(String[] args) {
        String filePath = "website_text.txt";
        List<String> links = extractLinks(filePath);

        // Print the extracted links
        for (String link : links) {
            System.out.println(link);
        }
    }
}

