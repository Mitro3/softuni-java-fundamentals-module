package exercises;

import java.util.Scanner;

public class P07_NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] array = array2D(n);
        printArray(array);

    }

    private static int[][] array2D(int n){
        int[][] array = new int[n][n];

        for (int rows = 0; rows < n; rows++) {
            for (int col = 0; col < n; col++) {
                array[rows][col] = n;
            }
        }

        return array;
    }

    private static void printArray(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
