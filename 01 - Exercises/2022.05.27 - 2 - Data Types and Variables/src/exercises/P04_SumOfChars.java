package exercises;

import java.util.Scanner;

public class P04_SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int charCount = scanner.nextInt();
        scanner.nextLine();
        int counter = 0;
        int sum = 0;

        while (counter < charCount){
            char currentChar = scanner.nextLine().charAt(0);
            sum += (int) currentChar;

            counter++;
        }
        System.out.println("The sum equals: " + sum);
    }
}
