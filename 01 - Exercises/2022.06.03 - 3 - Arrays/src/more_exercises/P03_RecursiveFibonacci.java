package more_exercises;

import java.util.Scanner;

public class P03_RecursiveFibonacci{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        System.out.println(getFibonacciNumber(n));
    }

    private static long getFibonacciNumber(long n){
        if (n == 0){
            return 0;
        } else if (n == 1){
            return 1;
        } else {
            return getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
        }
    }
}
