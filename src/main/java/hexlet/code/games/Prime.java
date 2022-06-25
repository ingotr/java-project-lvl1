package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.getMaxNum;

public class Prime extends Game {

    public Prime() {
        this.setWelcomeText("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    @Override
    public final String getCorrectAnswer() {
        Random random = new Random();
        int number = random.nextInt(getMaxNum()) + 1;
        System.out.format("Question: %d%n", number);
        return isNumberPrime(number);
    }

    private String isNumberPrime(int number) {
        int flag = 0;
        int maxNumber = number / 2;
        String result = "no";
        for (int i = 2; i <= maxNumber; i++) {
            if (number % i == 0) {
                result = "no";
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            result = "yes";
        }
        return result;
    }
}
