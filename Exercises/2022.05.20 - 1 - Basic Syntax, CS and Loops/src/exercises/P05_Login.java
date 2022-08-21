package exercises;

import java.util.Scanner;

public class P05_Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();

        String password = reverseText(username);

        boolean isLogged = login(username, password, scanner);

        if (isLogged){
            System.out.printf("User %s logged in.", username);
        } else {
            System.out.printf("User %s blocked!", username);
        }

    }

    private static String reverseText(String username){
        String reversedText = "";
        for (int i = (username.length() - 1); i >= 0; i--) {
            char currentLetter = username.charAt(i);
            reversedText += currentLetter;
        }

        return reversedText;
    }

    private static boolean login(String username, String password, Scanner scanner){
        int loginAttempts = 0;
        String input = scanner.nextLine();

        while (!input.equals(password)) {
            loginAttempts++;
            if (loginAttempts == 4) {
                return false;
            }
            System.out.println("Incorrect password. Try again.");

            input = scanner.nextLine();
        }

        return true;

    }
}
