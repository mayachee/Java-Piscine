package Java_Day_02.ex01;

import java.io.*;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Program <inputFile1> <inputFile2>");
            return;
        }
        if (!new File(args[0]).exists()) {
            System.out.println("File " + args[0] + " does not exist");
            return;
        }
        if (!new File(args[1]).exists()) {
            System.out.println("File " + args[1] + " does not exist");
            return;
        }
        String inputFile1 = args[0];
        String inputFile2 = args[1];

        try {
            List<String> dictionary = createDictionary(inputFile1, inputFile2);
            double[] vector1 = createVector(inputFile1, dictionary);
            double[] vector2 = createVector(inputFile2, dictionary);

            double similarity = calculateSimilarity(vector1, vector2);
            System.out.println("Similarity = " + similarity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Create a dictionary from the input files
    private static List<String> createDictionary(String inputFile1, String inputFile2) throws IOException {
        Set<String> dictionarySet = new HashSet<>();

        try (BufferedReader reader1 = new BufferedReader(new FileReader(inputFile1));
             BufferedReader reader2 = new BufferedReader(new FileReader(inputFile2))) {

            addToDictionary(reader1, dictionarySet);
            addToDictionary(reader2, dictionarySet);
        }

        List<String> dictionary = new ArrayList<>(dictionarySet);
        Collections.sort(dictionary);
        try (PrintWriter writer = new PrintWriter(new FileWriter("dictionary.txt"))) {
            for (String word : dictionary) {
                writer.println(word);
            }
        }
        System.out.println("Dictionary size = " + dictionary.size());
        return dictionary;
    }

    // Add words from a file to the dictionary set
    private static void addToDictionary(BufferedReader reader, Set<String> dictionarySet) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    dictionarySet.add(word.toLowerCase());
                }
            }
        }
    }

    // Create a vector based on the dictionary for a given file
    private static double[] createVector(String inputFile, List<String> dictionary) throws IOException {
        double[] vector = new double[dictionary.size()];

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        int index = Collections.binarySearch(dictionary, word.toLowerCase());
                        if (index >= 0) {
                            vector[index]++;
                        }
                    }
                }
            }
        }
        return vector;
    }

    // Calculate the similarity between two vectors using the cosine similarity measure
    private static double calculateSimilarity(double[] vector1, double[] vector2) {
        double dotProduct = 0.0;
        double magnitude1 = 0.0;
        double magnitude2 = 0.0;

        for (int i = 0; i < vector1.length; i++) {
            dotProduct += vector1[i] * vector2[i];
            magnitude1 += Math.pow(vector1[i], 2);
            magnitude2 += Math.pow(vector2[i], 2);
        }

        magnitude1 = Math.sqrt(magnitude1);
        magnitude2 = Math.sqrt(magnitude2);

        if (magnitude1 == 0 || magnitude2 == 0) {
            return 0.0;
        }

        return dotProduct / (magnitude1 * magnitude2);
    }
}
