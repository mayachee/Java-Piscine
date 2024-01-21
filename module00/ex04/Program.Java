package module00.ex04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input string
        String input = scanner.nextLine();

        // Close the scanner
        scanner.close();

        // Create a map to store character frequencies
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Count character occurrences
        for (char ch : input.toCharArray()) {
            // Check if the character is alphabetic
            if (Character.isAlphabetic(ch)) {
                // Increment the count in the map
                frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
            }
        }

        // Sort and display the histogram
        displayHistogram(frequencyMap);
    }

    private static void displayHistogram(Map<Character, Integer> frequencyMap) {
        // Sort the map entries by frequency and lexicographic order
        frequencyMap.entrySet()
                .stream()
                .sorted((entry1, entry2) -> {
                    int frequencyComparison = Integer.compare(entry2.getValue(), entry1.getValue());
                    return (frequencyComparison != 0) ? frequencyComparison : Character.compare(entry1.getKey(), entry2.getKey());
                })
                .limit(10)  // Display the top 10 characters
                .forEach(entry -> {
                    char ch = entry.getKey();
                    int frequency = entry.getValue();

                    // Display the character
                    System.out.print(ch + " ");

                    // Display the histogram
                    for (int i = 0; i < frequency; i++) {
                        System.out.print("# ");
                    }

                    System.out.println();
                });
    }
}

