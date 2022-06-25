package hexlet.code.games;

import java.util.Arrays;
import java.util.Random;

import static hexlet.code.Engine.getMaxNum;

public class Progression extends Game {

    public static final int MIN_PROGRESSION_LENGTH = 5;
    public static final int PROGRESSION_LENGTH_INCREMENT = 5;
    public static final int MAX_PROGRESSION_DIFFERENCE = 10;

    public Progression() {
        this.setWelcomeText("What number is missing in the progression?");
    }

    public final String getCorrectAnswer() {
        Random random = new Random();
        int progressionLength = random.nextInt(MIN_PROGRESSION_LENGTH) + PROGRESSION_LENGTH_INCREMENT;
        int firstNumber = random.nextInt(getMaxNum()) + 1;
        String[] progression = new String[progressionLength];

        int commonDifference = random.nextInt(MAX_PROGRESSION_DIFFERENCE) + 1;
        int currentItem = firstNumber;
        progression[0] = String.valueOf(currentItem);
        for (int i = 1; i < progressionLength; i++) {
            currentItem += commonDifference;
            progression[i] = String.valueOf(currentItem);
        }

        String hiddenReplacement = "..";
        int numOfHidden = random.nextInt(progressionLength);
        String result = progression[numOfHidden];
        progression[numOfHidden] = hiddenReplacement;

        String progressionString = Arrays.toString(progression);
        for (String s : Arrays.asList("[", "]")) {
            progressionString = progressionString.replace(s, "");
        }

        System.out.format("Question: %s %n", progressionString);

        return String.valueOf(result);
    }
}
