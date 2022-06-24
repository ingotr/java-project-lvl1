package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Random;

import static hexlet.code.Engine.getMaxNum;

public class GCD extends Game {

    public GCD() {
        this.setWelcomeText("Find the greatest common divisor of given numbers.");
    }

    @Override
    public boolean runGameCycle(String userName) {
        String correctAnswer = getCorrectAnswer();
        String userInput = Cli.getUserInput();
        boolean isAnswerCorrect = userInput.equals(correctAnswer);
        if (isAnswerCorrect) {
            System.out.println("Correct!");
        } else {
            System.out.format("%s is wrong answer ;(. Correct answer was %s. Let's try again, %s!%n",
                    userInput, correctAnswer, userName);
            return true;
        }
        return false;
    }

    private static String getCorrectAnswer() {
        Random random = new Random();
        int firstNumber = random.nextInt(getMaxNum()) + 1;
        int secondNumber = random.nextInt(getMaxNum()) + 1;
        System.out.format("Question: %d %d%n", firstNumber, secondNumber);
        int gcd = 1;
        for (int i = 1; i <= firstNumber && i <= secondNumber; i++) {
            if (firstNumber % i == 0 && secondNumber % i == 0) {
                gcd = i;
            }
        }
        return String.valueOf(gcd);
    }
}
