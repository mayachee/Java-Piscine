package Java_Day_03.ex02;

import java.util.Random;

public class Program {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Program.java --arraySize=<size> --threadsCount=<count>");
            return;
        }

        int arraySize = 0;
        int threadsCount = 0;

        for (String arg : args) {
            if (arg.startsWith("--arraySize=")) {
                arraySize = Integer.parseInt(arg.substring(12));
            } else if (arg.startsWith("--threadsCount=")) {
                threadsCount = Integer.parseInt(arg.substring(15));
            }
        }

        if (arraySize <= 0 || threadsCount <= 0) {
            System.out.println("Array size and number of threads must be positive integers.");
            return;
        }

        if (arraySize < threadsCount) {
            System.out.println("Number of threads cannot exceed array size.");
            return;
        }

        int[] array = generateRandomArray(arraySize);
        int sum = calculateSum(array);

        System.out.println("Sum: " + sum);


        int sectionSize = arraySize / threadsCount;
        int remainder = arraySize % threadsCount;

        Thread[] threads = new Thread[threadsCount];
        int startIndex = 0;
        for (int i = 0; i < threadsCount; i++) {
            int endIndex = startIndex + sectionSize - 1;
            if (i < remainder) {
                endIndex++;
            }
            threads[i] = new Thread(new SummingThread(i + 1, array, startIndex, endIndex));
            threads[i].start();
            startIndex = endIndex + 1;
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Sum by threads: " + sum);
    }

    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(11); // maximum modulo value of each array element is 1000
        }
        return array;
    }

    private static int calculateSum(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }
}

class SummingThread implements Runnable {
    private final int[] array;
    private final int startIndex;
    private final int endIndex;
    private final int threadNumber;

    public SummingThread(int threadNumber, int[] array, int startIndex, int endIndex) {
        this.threadNumber = threadNumber;
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += array[i];
        }
        System.out.println("Thread " + threadNumber + ": from " + startIndex + " to " + endIndex + " sum is " + sum);
    }
}
