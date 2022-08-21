package exercises;

import java.util.Scanner;

public class P07_StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        StringBuilder text = new StringBuilder(input);

        int totalPower = 0;
        for (int i = 0; i < text.length(); i++) {
            char currSymbol = text.charAt(i);
            if (currSymbol == '>') {
                int currPower = Integer.parseInt(String.valueOf(text.charAt(i + 1)));
                totalPower += currPower;
            } else if (currSymbol != '>' && totalPower > 0) {
                text.deleteCharAt(i);
                totalPower--;
                i--;
            }
        }

        System.out.println(text);

    }
}
