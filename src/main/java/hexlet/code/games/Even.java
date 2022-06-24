package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Random;

import static hexlet.code.Engine.getMaxNum;

public class Even extends Game {

    public Even() {
        this.setWelcomeText("Answer 'yes' if number even otherwise answer 'no'.");
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
        int number = random.nextInt(getMaxNum()) + 1;
        System.out.format("Question: %d%n", number);
        return isNumberEven(number);
    }

    public static String isNumberEven(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }
}
