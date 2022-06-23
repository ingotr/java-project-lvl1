package hexlet.code;

import java.util.Scanner;

public class App {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        String menuItems = """
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                0 - Exit
                """;
        String userChoice;

        do {
            System.out.println(menuItems);
            userChoice = SCANNER.nextLine();
            parseUserChoice(userChoice);
        } while (!userChoice.equals("0"));

    }

    private static void parseUserChoice(String userChoice) {
        switch (userChoice) {
            case "0" -> System.out.println("Thank you. See you again");
            case "1" -> parseGreet();
            case "2" -> Even.play();
            case "3" -> Calculator.play();
            default -> System.out.println("Неизвестный пункт меню. Попробуйте выбрать еще раз");
        }
    }

    private static void parseGreet() {
        System.out.println("Welcome to the Brain Games!");
        Cli.greetUser();
    }
}
