package hexlet.code;

import java.util.Scanner;

public class Cli {
    static Scanner scanner = new Scanner(System.in);

    public static void greetUser() {
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
    }
}
