package exercises;

import java.util.Scanner;

public class P04_CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder encryptedText = new StringBuilder();

        for (int position = 0; position < text.length(); position++) {
            char currChar = text.charAt(position);
            int newPosition = (int) currChar + 3;
            char newChar = (char) newPosition;
            encryptedText.append(newChar);
        }

        System.out.println(encryptedText);
    }
}
