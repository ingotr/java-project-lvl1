package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.getMaxNum;

public class Calculator extends Game {

    public static final int MATH_OPERATORS_COUNT = 3;

    public Calculator() {
        this.setWelcomeText("What is the result of the expression?");
    }

    public String getCorrectAnswer() {
        Random random = new Random();
        int firstNumber = random.nextInt(getMaxNum()) + 1;
        int secondNumber = random.nextInt(getMaxNum()) + 1;
        String mathSign = getMathSign();
        System.out.format("Question: %d %s %d%n", firstNumber, mathSign, secondNumber);

        int result =  switch (mathSign) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            default -> throw new IllegalStateException("Unexpected math operator: " + mathSign);
        };
        return String.valueOf(result);
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
