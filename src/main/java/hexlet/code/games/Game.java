package hexlet.code.games;

public abstract class Game {
    private String welcomeText;

    public abstract String getCorrectAnswer();

    public final String getWelcomeText() {
        return welcomeText;
    }

    public final void setWelcomeText(String text) {
        this.welcomeText = text;
    }
}
