package hexlet.code.games;

import java.util.Random;

import static hexlet.code.Engine.getMaxNum;

public class Even extends Game {

    public Even() {
        this.setWelcomeText("Answer 'yes' if number even otherwise answer 'no'.");
    }

    public final String getCorrectAnswer() {
        Random random = new Random();
        int number = random.nextInt(getMaxNum()) + 1;
        System.out.format("Question: %d%n", number);
        return isNumberEven(number);
    }

    private static String isNumberEven(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }
}
