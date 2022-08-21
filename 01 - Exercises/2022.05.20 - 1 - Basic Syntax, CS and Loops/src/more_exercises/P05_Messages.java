package more_exercises;
import java.util.Scanner;

public class P05_Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wordLength = scanner.nextInt();


        int countLetters = 0;
        String word = "";

        while (countLetters != wordLength){
            int input = scanner.nextInt();
            String inputToString = Integer.toString(input);

            if (input == 0){
                word = word + " ";
                countLetters++;
                continue;
            }

            int mainDigit = input % 10;
            int offset = (mainDigit - 2) * 3;

            if (mainDigit == 8 || mainDigit == 9){
                offset++;
            }

            int letterIndex = offset + inputToString.length() - 1;

            char letter = (char)(letterIndex + 97);
            word = word + letter;
            countLetters++;

        }

        System.out.println(word);

    }
}
