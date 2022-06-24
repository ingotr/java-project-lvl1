package hexlet.code.games;

import java.util.Arrays;
import java.util.Random;

import static hexlet.code.Engine.getMaxNum;

public class Progression extends Game {

    public Progression() {
        this.setWelcomeText("What number is missing in the progression?");
    }

    public String getCorrectAnswer() {
        Random random = new Random();
        int progressionLength = random.nextInt(5) + 5;
        int firstNumber = random.nextInt(getMaxNum()) + 1;
        String[] progression = new String[progressionLength];

        int commonDifference = random.nextInt(10) + 1;
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
