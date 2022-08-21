package exercises;

import java.util.Scanner;

public class P03_ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arraySize = scanner.nextInt();

        int[] firstArray = new int[arraySize];
        int[] secondArray = new int[arraySize];

        for (int rows = 0; rows < arraySize; rows++) {
            if (rows % 2 == 0) {
                firstArray[rows] = scanner.nextInt();
                secondArray[rows] = scanner.nextInt();
            } else {
                secondArray[rows] = scanner.nextInt();
                firstArray[rows] = scanner.nextInt();
            }
        }

        for (int i = 0; i < arraySize; i++) {
            System.out.print(firstArray[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arraySize; i++) {
            System.out.print(secondArray[i] + " ");
        }

    }
}
