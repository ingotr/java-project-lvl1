package hexlet.code.games;

public abstract class Game {
    private String welcomeText;

    public abstract String getCorrectAnswer();

    public String getWelcomeText() {
        return welcomeText;
    }

    public void setWelcomeText(String welcomeText) {
        this.welcomeText = welcomeText;
    }
}
