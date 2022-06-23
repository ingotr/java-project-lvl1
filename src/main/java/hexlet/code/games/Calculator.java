package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Random;

public class Calculator extends Game {

    public static final int MAX_NUM = 100;
    public static final int MATH_OPERATORS_COUNT = 3;

    public Calculator() {
        this.setWelcomeText("What is the result of the expression?");
    }

    @Override
    public boolean runGameCycle(String userName) {
        int correctAnswer = getCorrectAnswer();
        int userInput = Integer.parseInt(Cli.getUserInput());
        boolean isAnswerCorrect = (userInput == correctAnswer);
        if (isAnswerCorrect) {
            System.out.println("Correct!");
        } else {
            System.out.format("%s is wrong answer ;(. Correct answer was %s. Let's try again, %s!%n",
                    userInput, correctAnswer, userName);
            return true;
        }
        return false;
    }

    private static int getCorrectAnswer() {
        Random random = new Random();
        int firstNumber = random.nextInt(MAX_NUM) + 1;
        int secondNumber = random.nextInt(MAX_NUM) + 1;
        String mathSign = getMathSign();
        System.out.format("Question: %d %s % d%n", firstNumber, mathSign, secondNumber);

        return switch (mathSign) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            default -> throw new IllegalStateException("Unexpected math operator: " + mathSign);
        };
    }

    private static String getMathSign() {
        Random random = new Random();
        int number = random.nextInt(MATH_OPERATORS_COUNT);
        return switch (number) {
            case 0 -> "+";
            case 1 -> "-";
            case 2 -> "*";
            default -> throw new IllegalStateException("Unexpected value: " + number);
        };
    }
}
