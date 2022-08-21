package more_exercises;

import java.util.Scanner;

public class P05_MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArray = readArray(scanner);

        boolean isProductZero = isProductZero(numArray[0], numArray[1], numArray[2]);
        boolean isProductNegative = isProductNegative(numArray);
        printResult(isProductZero, isProductNegative);

    }

    private static int[] readArray (Scanner scanner){
        int[] array = new int[3];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        return array;
    }

    private static boolean isProductZero(int num1, int num2, int num3) {
        if (num1 == 0 || num2 == 0 || num3 == 0) {
            return true;
        }

        return false;
    }

    private static boolean isProductNegative(int[] array) {
        int countNegativeSign = 0;

        for (int element:
             array) {
            if (element < 0){
                countNegativeSign++;
            }
        }

        if (countNegativeSign % 2 != 0){
            return true;
        }

        return false;
    }

    private static void printResult(boolean isProductZero, boolean isProductNegative){
        if (isProductZero) {
            System.out.println("zero");
        } else if (isProductNegative){
            System.out.println("negative");
        } else {
            System.out.println("positive");
        }
    }
}
