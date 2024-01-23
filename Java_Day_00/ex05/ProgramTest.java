package module00.ex05;

import java.util.Scanner;

public class ProgramTest {
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Hello World!");

            String input = scanner.nextLine();

            // Close the scanner
            scanner.close();
            
            int i = 0;
            System.out.println(input.length());

            while (i < input.length()) {
                System.out.println("input[" + i + "] = " + input.charAt(i));
                i++;
            }

        }
}
