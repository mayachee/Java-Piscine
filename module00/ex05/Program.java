package module00.ex05;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a list of students
        System.out.println("Enter the names of students (enter '.' to finish):");
        String[] students = readStudentNames(scanner);

        // Create a timetable
        System.out.println("Enter the timetable (format: class_time DAY) For example : 4 WE :");
        String[][] timetable = readTimetable(scanner);

        // Record attendance
        System.out.println("Record attendance (format: student class_time day status):");
        recordAttendance(scanner, students, timetable);

        // Display the timetable with attendance
        displayTimetableWithAttendance(students, timetable);

        // Close the scanner
        scanner.close();
    }

    private static String[] readStudentNames(Scanner scanner) {
        String[] students = new String[10];
        int studentCount = 0;

        while (studentCount < 10) {
            String name = scanner.nextLine();

            if (".".equals(name)) {
                break;
            }

            // Ensure name length does not exceed 10 characters
            name = name.length() > 10 ? name.substring(0, 10) : name;

            students[studentCount] = name;
            studentCount++;
        }

        return students;
    }

    private static String[][] readTimetable(Scanner scanner) {
        String[][] timetable = new String[10][2];
        int classCount = 0;

        while (classCount < 10) {
            String input = scanner.nextLine();

            if (".".equals(input)) {
                break;
            }

            String[] tokens = input.split(" ");
            if (tokens.length == 2) {
                timetable[classCount][0] = tokens[0];
                timetable[classCount][1] = tokens[1];
                classCount++;
            } else {
                System.out.println("Invalid input. Please use the format: class_time DAY");
            }
        }

        return timetable;
    }

    private static void recordAttendance(Scanner scanner, String[] students, String[][] timetable) {
        while (true) {
            String input = scanner.nextLine();

            if (".".equals(input)) {
                break;
            }

            String[] tokens = input.split(" ");
            if (tokens.length == 4) {
                String studentName = tokens[0];
                String classTime = tokens[1];
                String day = tokens[2];
                String status = tokens[3];

                // System.out.println("--> studentName" + studentName);
                // System.out.println("--> classTime" + classTime);
                // System.out.println("--> day" + day);
                // System.out.println("--> status" + status);

                int studentIndex = findStudentIndex(students, studentName);
                int classIndex = findClassIndex(timetable, classTime, day);

                // System.out.println("--> studentIndex" + studentIndex);
                // System.out.println("--> findStudentIndex" + findStudentIndex(students, studentName));
                // System.out.println("--> classIndex" + classIndex);
                // System.out.println("--> findClassIndex" + findClassIndex(timetable, classTime, day));

                if (studentIndex != -1 && classIndex != -1) {
                    timetable[classIndex][studentIndex + 2] = status;
                } 
                else {
                    System.out.println("Invalid student or class information.");
                }

            } else {
                System.out.println("Invalid input. Please use the format: student class_time day status");
            }
        }
    }

    private static int findStudentIndex(String[] students, String studentName) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null 
            // && students[i].equals(studentName)
            ) {
                return i;
            }
        }
        return -1;
    }

    private static int findClassIndex(String[][] timetable, String classTime, String day) {
        for (int i = 0; i < timetable.length; i++) {
            if (timetable[i][0] != null && timetable[i][1] != null &&
                timetable[i][0].equals(classTime) && timetable[i][1].equals(day)) {
                return i;
            }
        }
        return -1;
    }

    private static void displayTimetableWithAttendance(String[] students, String[][] timetable)
    {
        System.out.println();

        // Display timetable header
        for (int i = 0; i < timetable.length; i++) {
            if (timetable[i][0] != null && timetable[i][1] != null) {
                System.out.printf("%s %s|", timetable[i][0], timetable[i][1]);
            }
        }
        System.out.println();

        // Display attendance status for each student in each class
        for (int studentIndex = 0; studentIndex < students.length; studentIndex++) {
            if (students[studentIndex] != null) {
                System.out.printf("%-10s", students[studentIndex]);

                for (int classIndex = 0; classIndex < timetable.length; classIndex++) {
                    if (timetable[classIndex][0] != null && timetable[classIndex][1] != null) {
                        String status = timetable[classIndex][studentIndex + 2];
                        System.out.printf("| %-4s", status != null ? status : "");
                    }
                }

                System.out.println();
            }
        }
    }
}
