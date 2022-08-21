package more_exercises;
import java.util.Scanner;

public class P04_ReveseString_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        printReverseString(input);
    }

    private static void printReverseString(String input){

        String reversedString = "";
        char ch;

        for (int i = 0; i < input.length(); i++){
            ch = input.charAt(i);
            reversedString = ch + reversedString;
        }

        System.out.println(reversedString);

    }
}
