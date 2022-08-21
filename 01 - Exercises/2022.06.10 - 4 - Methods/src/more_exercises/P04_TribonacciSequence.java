package more_exercises;

import java.util.Scanner;

public class P04_TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long[] tribonacciArray = new long[n];
        getFibonacciNumber(tribonacciArray);

        for (int i = 0; i < n; i++) {
            System.out.print(tribonacciArray[i] + " ");
        }
    }

    private static void getFibonacciNumber(long[] array) {
        array[0] = 1;
        if (array.length > 1) {
            array[1] = 1;
        }
        if (array.length > 2) {
            array[2] = 2;
        }


        for (int i = 3; i < array.length; i++) {
            array[i] = array[i - 1] + array[i - 2] + array[i - 3];
        }
    }
}


