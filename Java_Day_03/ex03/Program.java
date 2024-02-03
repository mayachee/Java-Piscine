package Java_Day_03.ex03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Program {
    private static final String FILE_URLS_PATH = "C:\\Users\\Dima D'origine\\java-module\\Java_Day_03\\ex03\\image_urls.txt";

    public static void main(String[] args) {
        int threadsCount = 3; // Default threads count
        if (args.length > 0) {
            for (String arg : args) {
                if (arg.startsWith("--threadsCount=")) {
                    threadsCount = Integer.parseInt(arg.substring(15));
                }
            }
        }

        List<String> urls = readUrlsFromFile(FILE_URLS_PATH);
        if (urls.isEmpty()) {
            System.out.println("No URLs found in " + FILE_URLS_PATH);
            return;
        }

        DownloadManager manager = new DownloadManager(urls, threadsCount);
        manager.startDownloading();
    }

    private static List<String> readUrlsFromFile(String filePath) {
        List<String> urls = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                urls.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urls;
    }
}

class DownloadManager {
    private final List<String> urls;
    private final int threadsCount;

    public DownloadManager(List<String> urls, int threadsCount) {
        this.urls = urls;
        this.threadsCount = threadsCount;
    }

    public void startDownloading() {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < threadsCount; i++) {
            Thread thread = new Thread(new DownloadThread(i + 1));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized String getNextUrl() {
        if (!urls.isEmpty()) {
            return urls.remove(0);
        }
        return null;
    }

    class DownloadThread implements Runnable {
        private final int threadNumber;

        public DownloadThread(int threadNumber) {
            this.threadNumber = threadNumber;
        }

        @Override
        public void run() {
            String url;
            while ((url = getNextUrl()) != null) {
                System.out.println("Thread-" + threadNumber + " start download file number " + (urls.size() + 1));
                downloadFile(url);
                System.out.println("Thread-" + threadNumber + " finish download file number " + (urls.size() + 1));
            }
        }

        private void downloadFile(String url) {
            try {
                String fileName = "C:\\\\Users\\\\Dima D'origine\\\\java-module\\\\Java_Day_03\\\\ex03\\\\upload\\\\file_" + threadNumber + "_" + urls.size() + ".jpg";
                Files.copy(new URL(url).openStream(), Paths.get(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
