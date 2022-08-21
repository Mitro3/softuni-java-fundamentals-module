package exercises;

import java.util.Scanner;

public class P02_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String firstString = input.split("\\s+")[0];
        String secondString = input.split("\\s+")[1];

        int totalSum = 0;

        int comparision = firstString.compareTo(secondString);
        String shorterString = "";
        String longerString = "";

        if (comparision <= 0) {
            shorterString = secondString;
            longerString = firstString;
        } else {
            shorterString = firstString;
            longerString = secondString;
        }

        for (int i = 0; i < shorterString.length(); i++) {
            int firstStringSymbol = (int) firstString.charAt(i);
            int secondStringSymbol = (int) secondString.charAt(i);
            int multiplicationProduct = firstStringSymbol * secondStringSymbol;
            totalSum += multiplicationProduct;

        }

        if (longerString.equals(firstString)) {
            for (int i = shorterString.length(); i < longerString.length(); i++) {
                int currSymbol = (int) firstString.charAt(i);
                totalSum += currSymbol;
            }
        } else if (longerString.equals(secondString)) {
            for (int i = shorterString.length(); i < longerString.length(); i++) {
                int currSymbol = (int) secondString.charAt(i);
                totalSum += currSymbol;
            }
        }

        System.out.println(totalSum);
    }
}
