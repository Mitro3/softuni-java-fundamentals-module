package more_exercises;
import java.util.Scanner;

public class P04_ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        printReverseString(input);
    }

    private static void printReverseString(String input){
        int size = input.length();
        char[] array = new char[size];

        for (int i = 0; i < array.length; i++){
            array[i] = input.charAt(i);
        }

        for (int j = array.length - 1; j >= 0; j--){
            System.out.print(array[j]);
        }

    }
}
