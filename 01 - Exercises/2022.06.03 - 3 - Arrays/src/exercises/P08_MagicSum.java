package exercises;

import java.util.Scanner;

public class P08_MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = readArray(scanner);

        int inputSum = scanner.nextInt();

        int firstPairIndex = 0;
        int secondPairIndex = 0;
        boolean isFound = false;

        for (int i = 0; i < array.length; i++) {
            int currentSum = 0;
            for (int j = i + 1; j < array.length; j++) {
                currentSum = array[i] + array[j];
                if (currentSum == inputSum) {
                    firstPairIndex = i;
                    secondPairIndex = j;
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                printArray(array, firstPairIndex, secondPairIndex);
            }
            isFound = false;
        }
    }

    private static int[] readArray(Scanner scanner) {

        String[] splitArray = scanner.nextLine().split(" ");
        int[] array = new int[splitArray.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(splitArray[i]);
        }

        return array;
    }

    private static void printArray(int[] array, int startIndex, int endIndex) {
            System.out.println(array[startIndex] + " " + array[endIndex]);
    }
}
