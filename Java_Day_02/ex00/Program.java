package Java_Day_02.ex00;

import java.io.*;
import java.util.*;

public class Program {
    private static Map<String, List<String>> signaturesMap = new HashMap<>();

    public static void main(String[] args) {
        // loadSignatures("signatures.txt");
        String currentDirectory = System.getProperty("user.dir");
        // System.out.println("Current working directory: " + currentDirectory);
        String signaturesFile = currentDirectory + File.separator + "Java_Day_02" + File.separator + "ex00" + File.separator + "signatures.txt";
        // System.out.println("signaturesFile: " + signaturesFile);
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
        loadSignatures(signaturesFile);

        if (signaturesFile.isEmpty()) {
            System.out.println("Error: Signatures file is empty or not found.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        String resultFile = currentDirectory + File.separator + "Java_Day_02" + File.separator + "ex00" + File.separator + "result.txt";
        System.out.println("resultFile: " + resultFile);
        try (PrintWriter writer = new PrintWriter(resultFile)) {

            while (true) {
                System.out.print("-> ");
                String filePath = scanner.nextLine().trim();
                if (filePath.equals("42"))
                {
                    System.out.println("Goodbye!");
                    break;
                } 

                String fileType = detectFileType(filePath);
                if (fileType != null) {
                    writer.println(fileType);
                    System.out.println("PROCESSED");
                } else {
                    System.out.println("UNDEFINED");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: result.txt file not found.");
        }
    }

    private static void loadSignatures(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",\\s*");
                if (parts.length == 2) {
                    String fileType = parts[0];
                    String[] signatures = parts[1].split("\\s+");
                    signaturesMap.put(fileType, Arrays.asList(signatures));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading signatures file: " + e.getMessage());
        }
    }

    private static String detectFileType(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            byte[] headerBytes = new byte[8]; // Read the first 8 bytes
            int bytesRead = fis.read(headerBytes);

            if (bytesRead == 8) {
                String headerHex = bytesToHex(headerBytes);
                for (Map.Entry<String, List<String>> entry : signaturesMap.entrySet()) {
                    List<String> signatures = entry.getValue();
                    if (signatures.contains(headerHex)) {
                        return entry.getKey();
                    }
                }
            }
        } catch (IOException e) {
            // Ignore or log the error, file cannot be processed
        }
        return null;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString().trim();
    }
}
