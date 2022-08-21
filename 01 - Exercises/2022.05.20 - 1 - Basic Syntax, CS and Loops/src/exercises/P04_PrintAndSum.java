package exercises;

import java.util.Scanner;

public class P04_PrintAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int lastNumber = Integer.parseInt(scanner.nextLine());

        printNumberRange(firstNumber, lastNumber);
    }

    private static void printNumberRange(int firstNumber, int lastNumber) {

        int sum = 0;
        for (int i = firstNumber; i <= lastNumber; i++){
            System.out.print(i + " ");
            sum += i;
        }

        System.out.println();
        System.out.println("Sum: " + sum);
    }
}
