package exercises;

import java.util.Scanner;

public class P06_StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        int sum = getSumFactorials(input);

        if (sum == input) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    private static int getSumFactorials(int input){
        int num = input;
        int sum = 0;

        while (num > 0) {
            int factorial = 1;
            int currentDigit = num % 10;
            num = num / 10;

            for (int i = 1; i <= currentDigit; i++) {
                factorial = factorial * i;
            }

            sum += factorial;
        }

        return sum;
    }
}
