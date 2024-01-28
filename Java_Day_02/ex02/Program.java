package Java_Day_02.ex02;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.*;
import java.lang.ProcessBuilder;

public class Program {
    private static Path currentDirectory;

    public static void main(String[] args) {
        if (args.length != 1 || !args[0].startsWith("--current-folder=")) {
            System.out.println("Usage: java Program --current-folder=<absolute_path>");
            return;
        }
        if (!Files.isDirectory(Paths.get(args[0].substring("--current-folder=".length())))) {
            System.out.println("Invalid folder path.");
            return;
        }

        String folderPath = args[0].substring("--current-folder=".length());
        List<String> commandHistory = new ArrayList<>();
        currentDirectory = Paths.get(folderPath);

        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;
            while (!exit) {
                System.out.print(currentDirectory + "\n-> ");
                String command = scanner.nextLine().trim();
                commandHistory.add(command); // Add command to history
                String[] parts = command.split("\\s+");

                switch (parts[0]) {
                    case "ls":
                        listFiles();
                        break;
                    case "cd":
                        if (parts.length != 2) {
                            System.out.println("Invalid cd command.");
                        } else {
                            changeDirectory(parts[1]);
                        }
                        break;
                    case "mv":
                        if (parts.length != 3) {
                            System.out.println("Invalid mv command.");
                        } else {
                            moveFile(parts[1], parts[2]);
                        }
                        break;
                    case "exit":
                        exit = true;
                        break;
                    default:
                    try {
                        ProcessBuilder processBuilder = new ProcessBuilder(parts);
                        // processBuilder.directory(new File(currentDirectory));
                        processBuilder.directory(currentDirectory.toFile());
                        Process process = processBuilder.start();
            
                        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
            
                        int exitCode = process.waitFor();
                        System.out.println("\nExited with error code : " + exitCode);
                    } catch (IOException | InterruptedException e) {
                        System.out.println("Error executing command: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void listFiles() throws IOException {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(currentDirectory)) {
            for (Path path : stream) {
                String type = Files.isDirectory(path) ? "folder" : "file";
                long size = Files.size(path) / 1024; // in KB
                System.out.println(path.getFileName() + " " + size + " KB");
            }
        }
    }

    private static void changeDirectory(String folderName) {
        Path newDirectory = currentDirectory.resolve(folderName);
        if (Files.isDirectory(newDirectory)) {
            currentDirectory = newDirectory;
        } else {
            System.out.println("Directory not found: " + folderName);
        }
    }

    private static void moveFile(String source, String destination) throws IOException {
        Path sourcePath = currentDirectory.resolve(source);
        Path destPath = currentDirectory.resolve(destination);

        if (Files.exists(sourcePath)) {
            if (Files.isDirectory(destPath)) {
                destPath = destPath.resolve(sourcePath.getFileName());
            }
            Files.move(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
        } else {
            System.out.println("File not found: " + source);
        }
    }
}
