import java.util.Scanner;

public class Main {
    private static final String[] QUESTIONS = {
            "Question 1: ...?",
            "Question 2: ...?",
            "Question 3: ...?",
            "Question 4: ...?",
            "Question 5: ...?"
    };

    private static final String[][] ANSWERS = {
            {"a. Answer A", "b. Answer B", "c. Answer C", "d. Answer D"},
            {"a. Answer A", "b. Answer B", "c. Answer C", "d. Answer D"},
            {"a. Answer A", "b. Answer B", "c. Answer C", "d. Answer D"},
            {"a. Answer A", "b. Answer B", "c. Answer C", "d. Answer D"},
            {"a. Answer A", "b. Answer B", "c. Answer C", "d. Answer D"}
    };

    private static final String[] CORRECT_ANSWERS = {"b", "a", "c", "d", "b"};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Future Simple Quiz!");
        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine();
        System.out.println("Hello, " + fullName + "! Let's begin the quiz.");
        int score = 0;
        int totalQuestions = QUESTIONS.length;

        for (int i = 0; i < totalQuestions; i++) {
            System.out.println();
            System.out.println(QUESTIONS[i]);

            for (String answer : ANSWERS[i]) {
                System.out.println(answer);
            }

            String userAnswer = getUserAnswer(scanner);

            if (userAnswer.equalsIgnoreCase(CORRECT_ANSWERS[i])) {
                score++;
            } else if (userAnswer.equalsIgnoreCase("q")) {
                break;
            }
        }

        double percentage = (score / (double) totalQuestions) * 100;
        System.out.println();
        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + totalQuestions);
        System.out.println("Percentage: " + percentage + "%");

        System.out.println();
        System.out.print("Enter the admin password to view correct answers: ");
        String adminPassword = scanner.nextLine();

        if (adminPassword.equals("1111")) {
            System.out.println("Correct Answers:");
            for (int i = 0; i < totalQuestions; i++) {
                System.out.println(QUESTIONS[i] + " - " + CORRECT_ANSWERS[i]);
            }
        }

        scanner.close();
    }

    private static String getUserAnswer(Scanner scanner) {
        String userAnswer;

        while (true) {
            System.out.print("Your answer (a, b, c, d) or q to quit: ");
            userAnswer = scanner.nextLine();

            if (userAnswer.matches("[abcdq]")) {
                break;
            } else {
                System.out.println("Invalid option! Please choose a valid answer.");
            }
        }

        return userAnswer;
    }
}
