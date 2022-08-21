package exercises;

import java.util.Scanner;

public class P04_ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = readArray(scanner);

        int rotationCount = scanner.nextInt();

        int[] rotatedArray = leftRotateArray(array, rotationCount);

        printArray(rotatedArray);
    }



    private static int[] readArray(Scanner scanner){
        String[] stringPieces = scanner.nextLine().split(" ");
        int[] array = new int[stringPieces.length];

        for (int i = 0; i < stringPieces.length; i++) {
            array[i] = Integer.parseInt(stringPieces[i]);
        }

        return array;
    }

    private static int[] leftRotateArray(int[] array, int rotationCount){
        for (int i = 0; i < rotationCount; i++) {
            int temp = array[0];

            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = temp;
        }

        return array;
    }

    private static void printArray(int[] rotatedArray) {
        for (int i = 0; i < rotatedArray.length; i++) {
            System.out.print(rotatedArray[i] + " ");
        }
    }
}
