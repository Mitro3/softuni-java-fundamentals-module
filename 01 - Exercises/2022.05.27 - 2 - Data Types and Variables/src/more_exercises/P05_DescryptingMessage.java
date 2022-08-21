package more_exercises;
import java.util.Scanner;

public class P05_DescryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = scanner.nextInt();
        int lineNumbers = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < lineNumbers; i++) {
            char currentChar = scanner.nextLine().charAt(0);
            char descryptedChar = (char)(currentChar + key);

            System.out.print(descryptedChar);
        }
    }
}
