package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Even {
    private static final int MAX_GAME_COUNT = 3;
    public static void play() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String userName = Cli.greetUser();
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
        runGameplay(random, scanner, userName);
    }

    private static void runGameplay(Random random, Scanner scanner, String userName) {
        int gameCount = 0;
        do {
            int number = random.nextInt(100) + 1;
            System.out.format("Question: %d%n", number);

            String userInput = scanner.nextLine().trim();
            System.out.format("Your answer: %s%n", userInput);

            if (runGameCycle(userName, number, userInput)) { break; }
            gameCount++;
        } while (gameCount < MAX_GAME_COUNT);
        System.out.format("Congratulations, %s!%n", userName);
    }

    private static boolean runGameCycle(String userName, int number, String userInput) {
        if (userInput.equals(isNumberEven(number))) {
            System.out.println("Correct!");
        } else {
            System.out.format("%s is wrong answer ;(. Correct answer was 'no'. Let's try again, %s!%n",
                    userInput, userName);
            return true;
        }
        return false;
    }

    public static String isNumberEven(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }
}
