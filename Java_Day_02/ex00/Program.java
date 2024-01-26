package Java_Day_02.ex00;

import java.io.*;
import java.util.*;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        // Path to the signatures file
        String signaturesFile = "C:\\Users\\Dima D'origine\\java-module\\Java_Day_02\\ex00\\signatures.txt";
        // System.out.println("-->" + signaturesFile);


        File file = new File(signaturesFile);

        if (!file.exists() || file.length() == 0) {
            System.out.println("Error: Signatures file is empty or not found.");
            return;
        } 
        else if (!file.canRead()) {
            System.out.println("Error: Cannot read the signatures file.");
            return;
        }
        // Load signatures from the file into a map
        Map<String, String> signatureMap = loadSignatures(signaturesFile);

        if (signatureMap.isEmpty()) {
            System.out.println("Error: Signatures file is empty or not found.");
            return;
        }

        // Process files and write results to result.txt
        try (Scanner scanner = new Scanner(System.in);
             PrintWriter writer = new PrintWriter(new FileWriter("result.txt"))) {

            while (true) {
                System.out.print("-> ");
                String filePath = scanner.nextLine().trim();

                // Exit the loop if user inputs an empty string
                if (filePath.isEmpty()) {
                    break;
                }
                if (filePath.equals("42")) {
                    System.out.println("Goodbye!");
                    return;
                }

                // Process the file
                String fileType = processFile(filePath, signatureMap);
                writer.println(fileType);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load signatures from the file into a map
    private static Map<String, String> loadSignatures(String filename) {
        Map<String, String> signatureMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 2) {
                    signatureMap.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return signatureMap;
    }

    // Process the file and determine its type based on signatures
    private static String processFile(String filePath, Map<String, String> signatureMap) {
        File file = new File(filePath);

        if (!file.exists() || !file.isFile()) {
            return "INVALID";
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] headerBytes = new byte[8];
            int bytesRead = fis.read(headerBytes);

            if (bytesRead == 8) {
                String headerHex = bytesToHex(headerBytes).toUpperCase();
                for (Map.Entry<String, String> entry : signatureMap.entrySet()) {
                    if (headerHex.startsWith(entry.getValue().toUpperCase())) {
                        return entry.getKey();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "UNDEFINED";
    }

    // Convert byte array to hexadecimal string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}
