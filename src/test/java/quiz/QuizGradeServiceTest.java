package quiz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuizGradeServiceTest {

    private final QuizGradeService service = new QuizGradeService();

    @Test
    void shouldReturnAForAverageBetween90And100() {
        assertEquals('A', service.toLetterGrade(90.0));
        assertEquals('A', service.toLetterGrade(95.5));
        assertEquals('A', service.toLetterGrade(100.0));
    }

    @Test
    void shouldReturnBForAverageBetween80And89() {
        assertEquals('B', service.toLetterGrade(80.0));
        assertEquals('B', service.toLetterGrade(89.9));
    }

    @Test
    void shouldReturnCForAverageBetween70And79() {
        assertEquals('C', service.toLetterGrade(70.0));
        assertEquals('C', service.toLetterGrade(79.9));
    }

    @Test
    void shouldReturnDForAverageBetween60And69() {
        assertEquals('D', service.toLetterGrade(60.0));
        assertEquals('D', service.toLetterGrade(69.9));
    }

    @Test
    void shouldReturnFFOrAverageBelow60() {
        assertEquals('F', service.toLetterGrade(59.9));
        assertEquals('F', service.toLetterGrade(0.0));
    }

    @Test
    void shouldSummarizeGradesCorrectly() {
        int[] grades = {90, 80, 70, 60, 100};

        QuizSummary summary = service.summarizeGrades(grades, 5);

        assertEquals(5, summary.getCount());
        assertEquals(400, summary.getTotal());
        assertEquals(80.0, summary.getAverage());
        assertEquals('B', summary.getLetterGrade());
        assertArrayEquals(new int[]{90, 80, 70, 60, 100}, summary.getGrades());
    }

    @Test
    void shouldHandleNoGradesEntered() {
        int[] grades = new int[QuizGradeService.MAX_GRADES];

        QuizSummary summary = service.summarizeGrades(grades, 0);

        assertEquals(0, summary.getCount());
        assertEquals(0, summary.getTotal());
        assertEquals(0.0, summary.getAverage());
        assertEquals('F', summary.getLetterGrade());
        assertArrayEquals(new int[0], summary.getGrades());
    }

    @Test
    void shouldRecognizeSentinelValue() {
        assertTrue(service.isSentinel(999));
        assertFalse(service.isSentinel(100));
    }

    @Test
    void shouldValidateGradeRange() {
        assertTrue(service.isValidGrade(0));
        assertTrue(service.isValidGrade(100));
        assertFalse(service.isValidGrade(-1));
        assertFalse(service.isValidGrade(101));
    }

    @Test
    void shouldRejectNullGradesArray() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> service.summarizeGrades(null, 0));

        assertEquals("grades must not be null", exception.getMessage());
    }

    @Test
    void shouldRejectCountGreaterThanArrayLength() {
        int[] grades = {90, 80};

        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> service.summarizeGrades(grades, 3));

        assertEquals("count is out of range", exception.getMessage());
    }

    @Test
    void shouldRejectInvalidStoredGrade() {
        int[] grades = {90, 101, 70};

        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> service.summarizeGrades(grades, 3));

        assertTrue(exception.getMessage().contains("Invalid grade at index 1"));
    }
}