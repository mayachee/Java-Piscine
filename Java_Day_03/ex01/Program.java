package Java_Day_03.ex01;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        // Check for the --count flag
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("=");
        if(!input[0].equals("--count")){
            System.err.println("Error: wrong flag");
            System.exit(-1);
        }
        int j = 0;
        while(!input[1].isEmpty() && j < input[1].length()){
            if (input[1].charAt(j) < '0' || input[1].charAt(j) > '9') {
                System.err.println("Error: wrong count");
                System.exit(-1);
            }
            j++;
        }
        int count = Integer.parseInt(input[1]);
        

        // int count = 50; // Default count
        if (args.length > 0) {
            for (String arg : args) {
                if (arg.startsWith("--count=")) {
                    count = Integer.parseInt(arg.substring(8));
                }
            }
        }

        // Using Runnable
        Runnable eggRunnable = new Egg(count);
        Thread eggThread = new Thread(eggRunnable);
        try {
            eggThread.start();
            eggThread.join(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Using Thread
        Hen henThread = new Hen(count);
        try {
            henThread.start();
            henThread.join(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Main thread's messages
        for (int i = 0; i < count; i++) {
            System.out.println("Human");
        }
    }
}
