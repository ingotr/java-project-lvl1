package hexlet.code;

import hexlet.code.games.Calculator;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;

import java.util.Scanner;

public class App {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Engine engine = new Engine();
        String menuItems = """
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                0 - Exit
                """;
        String userChoice;

        do {
            System.out.println(menuItems);
            userChoice = SCANNER.nextLine();
            parseUserChoice(userChoice, engine);
        } while (!userChoice.equals("0"));

    }

    private static void parseUserChoice(String userChoice, Engine engine) {
        switch (userChoice) {
            case "0" -> System.out.println("Thank you. See you again");
            case "1" -> parseGreet();
            case "2" -> engine.play(new Even());
            case "3" -> engine.play(new Calculator());
            case "4" -> engine.play(new GCD());
            default -> System.out.println("Неизвестный пункт меню. Попробуйте выбрать еще раз");
        }
    }

    private static void parseGreet() {
        System.out.println("Welcome to the Brain Games!");
        Cli.greetUser();
    }
}
