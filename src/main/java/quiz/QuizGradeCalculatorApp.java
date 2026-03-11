package quiz;

import java.util.Scanner;

public final class QuizGradeCalculatorApp {

    private QuizGradeCalculatorApp() {
    }

    public static void main(String[] args) {
        QuizGradeService service = new QuizGradeService();

        printProjectSpecifications(service);

        int[] grades = new int[QuizGradeService.MAX_GRADES];
        int count = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            while (count < QuizGradeService.MAX_GRADES) {
                System.out.print("Enter quiz grade #" + (count + 1) + " (0-100) or 999 to quit: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a whole number.");
                    scanner.next();
                    continue;
                }

                int input = scanner.nextInt();

                if (service.isSentinel(input)) {
                    break;
                }

                if (!service.isValidGrade(input)) {
                    System.out.println("Invalid grade. Enter a value from 0 to 100, or 999 to quit.");
                    continue;
                }

                grades[count] = input;
                count++;
            }
        }

        QuizSummary summary = service.summarizeGrades(grades, count);

        printGrades(summary);
        printSummary(summary);
    }

    private static void printProjectSpecifications(QuizGradeService service) {
        System.out.println(service.getProgrammingSpecifications());
    }

    private static void printGrades(QuizSummary summary) {
        System.out.println();
        System.out.println("Grades Entered");
        System.out.println("--------------");

        if (summary.getCount() == 0) {
            System.out.println("No grades were entered.");
            return;
        }

        int[] grades = summary.getGrades();
        for (int i = 0; i < summary.getCount(); i++) {
            System.out.println("Grade #" + (i + 1) + ": " + grades[i]);
        }
    }

    private static void printSummary(QuizSummary summary) {
        System.out.println();
        System.out.println("Results");
        System.out.println("-------");
        System.out.println("Number of grades entered: " + summary.getCount());
        System.out.println("Total of grades: " + summary.getTotal());
        System.out.printf("Average quiz grade: %.2f%n", summary.getAverage());
        System.out.println("Letter grade: " + summary.getLetterGrade());
    }
}