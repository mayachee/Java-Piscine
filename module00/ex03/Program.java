package module00.ex03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// $> java Program
// -> Week 1
// -> 4 5 2 4 2
// -> Week 2
// -> 7 7 7 7 6
// -> Week 3
// -> 4 3 4 9 8
// -> Week 4
// -> 9 9 4 6 7
// -> 42
// Week 1 ==>
// Week 2 ======>
// Week 3 ===>
// Week 4 ====>
// $>

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> weekData = new HashMap<>();
        System.out.println("Entre 'Week' and number between 1 and 18");
        while (true) {
            // Read week information
            System.out.print("-> ");
            String weekInput = scanner.nextLine().trim();

            if (weekInput.equals("42")) {
                break;
            }

            if (weekInput.startsWith("Week ")) {
                // Extract week number
                int weekNumber;
                try {
                    weekNumber = Integer.parseInt(weekInput.substring(5).trim());
                } catch (NumberFormatException e) {
                    System.err.println("IllegalArgument");
                    System.exit(-1);
                    return;
                }

                // Validate the order of weekly data input
                if (weekData.containsKey(weekNumber)) {
                    System.err.println("IllegalArgument");
                    System.exit(-1);
                    return;
                }

                // Read and process grades input
                System.out.print("-> ");
                String[] gradesInput = scanner.nextLine().trim().split(" ");

                if (gradesInput.length != 5) {
                    System.err.println("IllegalArgument");
                    System.exit(-1);
                    return;
                }

                // Find and store the minimum grade
                int minGrade = Integer.MAX_VALUE;
                for (String grade : gradesInput) {
                    try {
                        int numericGrade = Integer.parseInt(grade.trim());
                        if (numericGrade < 1 || numericGrade > 9) {
                            System.err.println("IllegalArgument");
                            System.exit(-1);
                            return;
                        }
                        minGrade = Math.min(minGrade, numericGrade);
                    } catch (NumberFormatException e) {
                        System.err.println("IllegalArgument");
                        System.exit(-1);
                        return;
                    }
                }

                // Store the data in the map
                weekData.put(weekNumber, minGrade);
            }
        }

        // Display the graph
        for (int i = 1; i <= 18; i++) {
            // System.out.println(" " + i);
            // System.out.println("-->> " + weekData.containsKey(i));
            if (weekData.containsKey(i)) {
                System.out.print("Week " + i + " ");
                for (int j = 1; j <= weekData.get(i); j++) {
                    System.out.print("=");
                }
                System.out.println(">");
            }
        }

        scanner.close();
    }
}
