package exercises;

import java.util.Scanner;

public class P08_FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();

        long firstNumFactorial = getFactorial(firstNumber);
        long secondNumFactorial = getFactorial(secondNumber);

        double divResult = 1.0 * firstNumFactorial / secondNumFactorial;
        System.out.printf("%.2f", divResult);
    }

    private static long getFactorial(int num){
        if (num >= 1) {
            return num * getFactorial(num - 1);
        }
        else {
            return 1;
        }
    }
}
