package hexlet.code;

import hexlet.code.games.Game;

public class Engine {
    private static final int MAX_GAME_COUNT = 3;
    private Game currentGame;

    public void play(Game currentGame) {
        setCurrentGame(currentGame);
        System.out.println(currentGame.getWelcomeText());
        runGameplay();
    }

    private void runGameplay() {
        int gameCount = 0;
        String userName = Cli.greetUser();
        do {
            if (currentGame.runGameCycle(userName)) {
                break;
            }
            gameCount++;
        } while (gameCount < MAX_GAME_COUNT);
        System.out.format("Congratulations, %s!%n", userName);
    }

    private void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }
}