# Quiz Grade Calculator

A Java console application that allows a user to enter quiz grades, stores them in an array, prints the grades, computes the average, and determines the corresponding letter grade.

The project also includes **unit tests using JUnit 5** to validate the grade calculation logic.

---

# Project Overview

This program performs the following tasks:

1. Prints the **programming specifications**.
2. Accepts quiz grades from the keyboard.
3. Stops accepting grades when:

    * The user enters **999**, or
    * **10 grades** have been entered.
4. Stores the grades in an **array**.
5. Prints all grades entered.
6. Computes the **average quiz grade**.
7. Determines the **letter grade** using the grading scale:

| Grade | Range  |
| ----- | ------ |
| A     | 90–100 |
| B     | 80–89  |
| C     | 70–79  |
| D     | 60–69  |
| F     | 0–59   |

The core logic is separated from console input/output so it can be **tested independently**.

---

# Project Structure

```
quiz-grade-calculator
│
├── pom.xml
│
├── src
│   ├── main
│   │   └── java
│   │       └── com/example/quiz
│   │           ├── QuizGradeCalculatorApp.java
│   │           ├── QuizGradeService.java
│   │           └── QuizSummary.java
│   │
│   └── test
│       └── java
│           └── com/example/quiz
│               └── QuizGradeServiceTest.java
│
└── README.md
```

---

# Requirements

Before running the project, install the following software.

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

## Maven

This project uses **Maven** for dependency management and running tests.

Check installation:

```bash
mvn -version
```

---

# How to Run the Application

## Step 1 — Clone or download the project

```bash
git clone <repository-url>
cd quiz-grade-calculator
```

Or download the project ZIP and extract it.

---

## Step 2 — Compile the project

Run:

```bash
mvn compile
```

Maven will:

* download dependencies
* compile the Java source files

---

## Step 3 — Run the program

Execute:

```bash
mvn exec:java -Dexec.mainClass="com.example.quiz.QuizGradeCalculatorApp"
```

---

## Example Program Execution

```
Project Specifications
----------------------
1. Accept quiz grades from the keyboard.
2. Stop input when the user enters 999 or when 10 grades have been entered.

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

# How to Run the Unit Tests

Unit tests verify the correctness of the grade calculation logic.

The tests are written using **JUnit 5**.

---

## Run all tests

From the project root directory run:

```bash
mvn test
```

Maven will:

1. Compile the main code
2. Compile the test code
3. Execute all JUnit tests

---

## Example Test Output

```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.example.quiz.QuizGradeServiceTest

Tests run: 11, Failures: 0, Errors: 0, Skipped: 0

BUILD SUCCESS
```

---

# Running Tests From an IDE

Most IDEs detect JUnit automatically.

### IntelliJ IDEA

1. Open the project.
2. Wait for Maven dependencies to load.
3. Navigate to:

```
src/test/java/com/example/quiz/QuizGradeServiceTest.java
```

4. Click the **Run** icon next to the test class.

---

### Eclipse

1. Import the project as a **Maven project**.
2. Open:

```
QuizGradeServiceTest.java
```

3. Right click → **Run As → JUnit Test**

---

# Key Design Decisions

## Separation of Concerns

The project separates responsibilities:

| Component                | Responsibility           |
| ------------------------ | ------------------------ |
| `QuizGradeCalculatorApp` | Console input/output     |
| `QuizGradeService`       | Business logic           |
| `QuizSummary`            | Immutable data structure |
| `QuizGradeServiceTest`   | Unit testing             |

This design improves:

* maintainability
* testability
* code clarity

---

# License

This project is intended for **educational purposes**.
