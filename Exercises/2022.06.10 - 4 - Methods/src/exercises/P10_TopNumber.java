package exercises;

import java.util.Scanner;

public class P10_TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        for (int i = 1; i <= num; i++) {
            if (isSumDivisibleBy8(i) && searchOddNum(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isSumDivisibleBy8(int num) {
        boolean isDivisible = true;

        int sum = 0;
        while (num > 0) {
            int lastDigit = num % 10;
            sum += lastDigit;
            num = num / 10;
        }

        if (sum % 8 != 0){
            isDivisible = false;
        }

        return isDivisible;
    }

    private static boolean searchOddNum(int num){
        while (num > 0) {
            int lastDigit = num % 10;
            if (lastDigit % 2 != 0) {
                return true;
            }
            num = num / 10;
        }

        return false;
    }
}
