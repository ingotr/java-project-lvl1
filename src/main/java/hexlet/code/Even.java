package hexlet.code;

import java.util.Random;
public class Even {
    private static final int MAX_GAME_COUNT = 3;
    public static void play() {
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
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

    private static String getCorrectAnswer() {
        Random random = new Random();
        int number = random.nextInt(100) + 1;
        System.out.format("Question: %d%n", number);
        return isNumberEven(number);
    }

    private static boolean runGameCycle(String userName) {
        String correctAnswer = getCorrectAnswer();
        String userInput = Cli.getUserInput();
        if (userInput.equals(correctAnswer)) {
            System.out.println("Correct!");
        } else {
            System.out.format("%s is wrong answer ;(. Correct answer was %s. Let's try again, %s!%n",
                    userInput, correctAnswer, userName);
            return true;
        }
        return false;
    }

    public static String isNumberEven(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }
}
