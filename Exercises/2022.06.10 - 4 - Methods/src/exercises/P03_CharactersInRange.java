package exercises;

import java.util.Scanner;

public class P03_CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);

        printCharsInRange(firstChar, secondChar);
        System.out.println();
    }

    private static void printCharsInRange(char firstChar, char secondChar){
        char startChar, endChar;
        if (firstChar < secondChar){
            startChar = firstChar;
            endChar = secondChar;
        } else {
            startChar = secondChar;
            endChar = firstChar;
        }

        for (int i = startChar + 1; i < endChar; i++) {
            char currentChar = (char) i;
            System.out.print(currentChar + " ");
        }

    }
}
