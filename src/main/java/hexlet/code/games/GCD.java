package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.getMaxNum;

public class GCD extends Game {

    public GCD() {
        this.setWelcomeText("Find the greatest common divisor of given numbers.");
    }

    public final String getCorrectAnswer() {
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
