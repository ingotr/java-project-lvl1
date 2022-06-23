package hexlet.code;

import java.util.Random;

public class Calculator {

    private static final int MAX_GAME_COUNT = 3;
    public static void play() {
        System.out.println("What is the result of the expression?");
        runGameplay();
    }

    private static void runGameplay() {
        int gameCount = 0;
        String userName = Cli.greetUser();
        do {
            if (runGameCycle(userName)) { break; }
            gameCount++;
        } while (gameCount < MAX_GAME_COUNT);
        System.out.format("Congratulations, %s!%n", userName);
    }

    private static boolean runGameCycle(String userName) {
        int correctAnswer = getCorrectAnswer();
        int userInput = Integer.parseInt(Cli.getUserInput());
        if (userInput == correctAnswer) {
            System.out.println("Correct!");
        } else {
            System.out.format("%s is wrong answer ;(. Correct answer was %s. Let's try again, %s!%n",
                    userInput, correctAnswer, userName);
            return true;
        }
        return false;
    }

    public static int getCorrectAnswer() {
        Random random = new Random();
        int firstNumber = random.nextInt(100) + 1;
        int secondNumber = random.nextInt(100) + 1;
        String mathSign = getMathSign();
        System.out.format("Question: %d %s % d%n", firstNumber, mathSign, secondNumber);

        return switch(mathSign) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            default -> throw new IllegalStateException("Unexpected math operator: " + mathSign);
        };
    }

    private static String getMathSign() {
        Random random = new Random();
        int number = random.nextInt(3);
        return switch (number) {
            case 0 -> "+";
            case 1 -> "-";
            case 2 -> "*";
            default -> throw new IllegalStateException("Unexpected value: " + number);
        };
    }
}
