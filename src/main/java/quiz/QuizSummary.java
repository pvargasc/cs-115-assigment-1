package quiz;

import java.util.Arrays;

public final class QuizSummary {
    private final int[] grades;
    private final int count;
    private final int total;
    private final double average;
    private final char letterGrade;

    public QuizSummary(int[] grades, int count, int total, double average, char letterGrade) {
        this.grades = Arrays.copyOf(grades, grades.length);
        this.count = count;
        this.total = total;
        this.average = average;
        this.letterGrade = letterGrade;
    }

    public int[] getGrades() {
        return Arrays.copyOf(grades, grades.length);
    }

    public int getCount() {
        return count;
    }

    public int getTotal() {
        return total;
    }

    public double getAverage() {
        return average;
    }

    public char getLetterGrade() {
        return letterGrade;
    }
}