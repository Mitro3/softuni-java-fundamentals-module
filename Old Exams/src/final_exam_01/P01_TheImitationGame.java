package final_exam_01;
import java.util.Scanner;

public class P01_TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();
        StringBuilder decryptedMessage = new StringBuilder(encryptedMessage);

        String input = scanner.nextLine();
        while (!input.equals("Decode")) {
            if (input.contains("Move")) {
                int countMovements = Integer.parseInt(input.split("\\|")[1]);
                for (int move = 0; move < countMovements; move++) {
                    char currChar = decryptedMessage.charAt(0);
                    decryptedMessage.deleteCharAt(0);
                    decryptedMessage.append(currChar);
                }

            } else if (input.contains("Insert")) {
                int index = Integer.parseInt(input.split("\\|")[1]);
                String currInsertChar = input.split("\\|")[2];
                decryptedMessage.insert(index, currInsertChar);

            } else if (input.contains("ChangeAll")) {
                String replacedChar = input.split("\\|")[1];
                String replacementChar = input.split("\\|")[2];
                String replacedString = decryptedMessage.toString()
                        .replace(replacedChar, replacementChar);
                decryptedMessage = new StringBuilder(replacedString);
            }

            input = scanner.nextLine();
        }

        System.out.println("The decrypted message is: " + decryptedMessage);
    }
}
