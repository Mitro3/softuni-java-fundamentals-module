package exercises;

import java.util.Scanner;

public class P05_PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startIndex = scanner.nextInt();
        int endIndex = scanner.nextInt();

        for (int i = startIndex; i <= endIndex; i++) {
            char currentChar = (char)i;
            System.out.print(currentChar + " ");
        }
    }
}
