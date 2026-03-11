# Quiz Grade Calculator

A Java console application that allows a user to enter quiz grades, store them in an array, print the grades, compute the average, and determine the corresponding letter grade.

The project also includes **unit tests using JUnit 5** to verify the grade-calculation logic.

---

# Project Overview

The program performs the following tasks:

1. Prints the programming specifications.
2. Accepts quiz grades from the keyboard.
3. Stops input when:

   * The user enters **999**, or
   * **10 grades** have been entered.
4. Stores the grades in an **array**.
5. Prints all entered grades.
6. Computes the **average quiz grade**.
7. Determines the **letter grade** using the grading scale:

| Grade | Range  |
| ----- | ------ |
| A     | 90–100 |
| B     | 80–89  |
| C     | 70–79  |
| D     | 60–69  |
| F     | 0–59   |

---

# Project Structure

```
cs-115-assignment-1
│
├── pom.xml
│
├── src
│   ├── main
│   │   └── java
│   │       └── quiz
│   │           ├── QuizGradeCalculatorApp.java
│   │           ├── QuizGradeService.java
│   │           └── QuizSummary.java
│   │
│   └── test
│       └── java
│           └── quiz
│               └── QuizGradeServiceTest.java
│
└── README.md
```

---

# Requirements

Install the following software.

## Java

Java **17 or newer**.

Check installation:

```bash
java -version
```

Example output:

```
java 17.0.x
```

---

# Running the Program

The program can be run **with Maven** or **without Maven**.

---

# Option 1 — Run with Maven

### Compile the project

```bash
mvn compile
```

### Run the program

```bash
mvn exec:java -Dexec.mainClass="quiz.QuizGradeCalculatorApp"
```

---

# Option 2 — Run Without Maven (Using Java CLI)

If Maven is not installed, the project can be compiled and executed using the Java compiler.

## Step 1 — Compile the source code

From the **project root directory** run:

```bash
javac -d out src/main/java/quiz/*.java
```

Explanation:

* `javac` compiles Java source files.
* `-d out` places compiled `.class` files into the `out` directory.

---

## Step 2 — Run the program

```bash
java -cp out quiz.QuizGradeCalculatorApp
```

Explanation:

* `-cp out` tells Java where the compiled classes are located.
* `quiz.QuizGradeCalculatorApp` is the fully qualified class containing `main()`.

---

# Example Program Execution

```
Project Specifications
----------------------
Enter quiz grade #1 (0-100) or 999 to quit: 90
Enter quiz grade #2 (0-100) or 999 to quit: 85
Enter quiz grade #3 (0-100) or 999 to quit: 70
Enter quiz grade #4 (0-100) or 999 to quit: 999

Grades Entered
--------------
Grade #1: 90
Grade #2: 85
Grade #3: 70

Results
-------
Number of grades entered: 3
Total of grades: 245
Average quiz grade: 81.67
Letter grade: B
```

---

# Running Unit Tests

Unit tests are written using **JUnit 5** and require Maven to execute.

Run all tests:

```bash
mvn test
```

Example output:

```
Tests run: 11, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

---

# Running Tests in IntelliJ

1. Open the project in IntelliJ IDEA.
2. Navigate to:

```
src/test/java/quiz/QuizGradeServiceTest.java
```

3. Right click the file.
4. Select:

```
Run 'QuizGradeServiceTest'
```

---

# Design Overview

The project separates responsibilities to improve maintainability and testability.

| Component                | Responsibility          |
| ------------------------ | ----------------------- |
| `QuizGradeCalculatorApp` | Console input/output    |
| `QuizGradeService`       | Grade calculation logic |
| `QuizSummary`            | Immutable result object |
| `QuizGradeServiceTest`   | Unit tests              |

---

# License

This project is intended for **educational use**.
