package more_exercises;

import java.util.Scanner;

public class P03_RecursiveFibonacci_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextInt();

        System.out.println(getFibonacciNumber(n));
    }

    private static int getFibonacciNumber(long n){
        int a = 0, b = 1, c;

        if (n == 0){
            return a;
        }

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
