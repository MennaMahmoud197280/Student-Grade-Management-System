
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] studentsNamesArray = new String[5];
        int[][] grades = new int[5][3];

        int grade;

        for (int i = 0; i < studentsNamesArray.length; i++) {

            System.out.println("Enter student name:");
            studentsNamesArray[i] = input.nextLine();

            for (int j = 0; j < grades[i].length; j++) {

                do {
                    System.out.print("Enter grade of student "
                            + studentsNamesArray[i]
                            + " in subject number " + (j + 1) + " : ");

                    grade = input.nextInt();

                    if (grade < 0 || grade > 100) {
                        System.out.println("Invalid grade.");
                        System.out.println("Grades must be between 0 and 100.");
                    }

                } while (grade < 0 || grade > 100);

                grades[i][j] = grade;
            }

            input.nextLine();
        }

        int choice;

        do {

            choice = showMenu(input);
            input.nextLine();

            switch (choice) {

                case 1:
                    showAllStudentsnames(studentsNamesArray);
                    break;

                case 2:
                    showAllStudentsGradesInEachSubject(studentsNamesArray, grades);
                    break;

                case 3:
                    System.out.println("Enter student name:");
                    String studentName = input.nextLine();

                    searchStudentByName(studentsNamesArray, studentName, grades);
                    break;

                case 4:
                    countPassedStudents(grades);
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        input.close();

        averageForEachSubject(grades);
        displayHighestGradeInEachSubject(grades);
        displayLetterGrades(studentsNamesArray, grades);
    }

    public static void showAllStudentsnames(String[] studentsNamesArray) {

        System.out.println("All students names:");

        for (int i = 0; i < studentsNamesArray.length; i++) {
            System.out.println(studentsNamesArray[i]);
        }
    }

    public static void showAllStudentsGradesInEachSubject(
            String[] studentsNamesArray, int[][] grades) {

        for (int i = 0; i < grades.length; i++) {

            System.out.println("The Grades of Student "
                    + studentsNamesArray[i] + " are:");

            for (int j = 0; j < grades[i].length; j++) {

                System.out.println("In Subject number "
                        + (j + 1) + " is: " + grades[i][j]);
            }
        }
    }

    public static void searchStudentByName(
            String[] studentsNamesArray, String studentName, int[][] grades) {

        boolean found = false;

        for (int i = 0; i < studentsNamesArray.length; i++) {

            if (studentsNamesArray[i].equalsIgnoreCase(studentName)) {

                found = true;

                System.out.println("The grades of student "
                        + studentsNamesArray[i] + " are:");

                for (int j = 0; j < grades[i].length; j++) {

                    System.out.println("In Subject number "
                            + (j + 1) + " is: " + grades[i][j]);
                }

                break;
            }
        }

        if (!found) {
            System.out.println("This name is not found.");
        }
    }

    public static void countPassedStudents(int[][] grades) {

        int count = 0;
        int degreeOfPassedStudents = 150;

        for (int i = 0; i < grades.length; i++) {

            int totalDegree = 0;

            for (int j = 0; j < grades[i].length; j++) {
                totalDegree += grades[i][j];
            }

            if (totalDegree >= degreeOfPassedStudents) {
                count++;
            }
        }

        System.out.println("Total number of students passed: " + count);
    }

    public static int showMenu(Scanner input) {

        System.out.println("\nMain Menu:");
        System.out.println("1) Show All Students names.");
        System.out.println("2) Show all Students grades in each subject.");
        System.out.println("3) Search Student by name.");
        System.out.println("4) Count Passed Students.");
        System.out.println("0) Exit");

        System.out.println("Enter your choice:");

        return input.nextInt();
    }

    public static void averageForEachSubject(int[][] grades) {

        for (int i = 0; i < grades[0].length; i++) {

            int sum = 0;

            for (int j = 0; j < grades.length; j++) {
                sum += grades[j][i];
            }

            double average = (double) sum / grades.length;

            System.out.println("The Average of Subject " + (i + 1) + ": " + average);
        }
    }

    public static void displayHighestGradeInEachSubject(int[][] grades) {

        for (int i = 0; i < grades[0].length; i++) {

            int maxGrade = grades[0][i];

            for (int j = 0; j < grades.length; j++) {

                if (maxGrade < grades[j][i]) {
                    maxGrade = grades[j][i];
                }
            }

            System.out.println("The Highest Grade in Subject " + (i + 1) + ": " + maxGrade);
        }
    }

    public static void displayLetterGrades(String[] studentsNamesArray, int[][] grades) {

        for (int i = 0; i < grades.length; i++) {

            System.out.println("The Letter Grades of Student ("
                    + studentsNamesArray[i] + ") are: ");

            for (int j = 0; j < grades[i].length; j++) {

                char letter;

                if (grades[i][j] >= 85) {
                    letter = 'A';
                } else if (grades[i][j] >= 75) {
                    letter = 'B';
                } else if (grades[i][j] >= 65) {
                    letter = 'C';
                } else if (grades[i][j] >= 50) {
                    letter = 'D';
                } else {
                    letter = 'F';
                }

                System.out.println("The letter Grade of Subject "
                        + (j + 1) + ": " + letter);
            }
        }
    }
}
