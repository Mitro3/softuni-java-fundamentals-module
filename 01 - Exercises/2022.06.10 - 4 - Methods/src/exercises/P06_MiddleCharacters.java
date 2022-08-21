package exercises;

import java.util.Scanner;

public class P06_MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println(getMiddleCharacter(input));
    }

    private static String getMiddleCharacter(String input) {
        char[] array = new char[input.length()];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.charAt(i);
        }

        int midIndex = input.length() / 2;
        String midChar = "";

        if (input.length() % 2 != 0) {
            midChar = "" + array[midIndex];
        } else {
            midChar = "" + ((char)array[midIndex - 1]) + ((char)array[midIndex]);
        }

        return midChar;
    }
}
