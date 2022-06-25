package hexlet.code;

import hexlet.code.games.Game;

public final class Engine {
    private static final int MAX_GAME_COUNT = 3;
    private static final int MAX_NUM = 100;

    private Game currentGame;

    public void play(Game game) {
        setCurrentGame(game);
        System.out.println(currentGame.getWelcomeText());
        runGameplay();
    }

    private void runGameplay() {
        int gameCount = 0;
        String userName = Cli.greetUser();
        do {
            if (runGameCycle(userName)) {
                break;
            }
            gameCount++;
        } while (gameCount < MAX_GAME_COUNT);
        System.out.format("Congratulations, %s!%n", userName);
    }

    private boolean runGameCycle(String userName) {
        String correctAnswer = currentGame.getCorrectAnswer();
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

    public void setCurrentGame(Game game) {
        this.currentGame = game;
    }

    public static int getMaxNum() {
        return MAX_NUM;
    }
}
