package quiz;

import java.util.Arrays;

public final class QuizGradeService {
    public static final int MAX_GRADES = 10;
    public static final int SENTINEL = 999;
    public static final int MIN_GRADE = 0;
    public static final int MAX_GRADE = 100;

    public String getProgrammingSpecifications() {
        return """
                Project Specifications
                ----------------------
                1. Accept quiz grades from the keyboard.
                2. Stop input when the user enters 999 or when 10 grades have been entered.
                3. Store grades in an array.
                4. Print all entered grades.
                5. Compute the average quiz grade.
                6. Determine the average letter grade using this scale:
                   A = 90-100
                   B = 80-89
                   C = 70-79
                   D = 60-69
                   F = 0-59
                """;
    }

    public boolean isSentinel(int value) {
        return value == SENTINEL;
    }

    public boolean isValidGrade(int value) {
        return value >= MIN_GRADE && value <= MAX_GRADE;
    }

    public QuizSummary summarizeGrades(int[] inputGrades, int count) {
        validateArguments(inputGrades, count);

        int[] storedGrades = Arrays.copyOf(inputGrades, count);

        int total = 0;
        for (int i = 0; i < count; i++) {
            total += storedGrades[i];
        }

        double average = count == 0 ? 0.0 : (double) total / count;
        char letterGrade = toLetterGrade(average);

        return new QuizSummary(storedGrades, count, total, average, letterGrade);
    }

    public char toLetterGrade(double average) {
        if (average >= 90.0) {
            return 'A';
        } else if (average >= 80.0) {
            return 'B';
        } else if (average >= 70.0) {
            return 'C';
        } else if (average >= 60.0) {
            return 'D';
        } else {
            return 'F';
        }
    }

    private void validateArguments(int[] grades, int count) {
        if (grades == null) {
            throw new IllegalArgumentException("grades must not be null");
        }
        if (count < 0 || count > grades.length) {
            throw new IllegalArgumentException("count is out of range");
        }
        if (count > MAX_GRADES) {
            throw new IllegalArgumentException("count cannot exceed " + MAX_GRADES);
        }

        for (int i = 0; i < count; i++) {
            if (!isValidGrade(grades[i])) {
                throw new IllegalArgumentException("Invalid grade at index " + i + ": " + grades[i]);
            }
        }
    }
}