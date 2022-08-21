package exercises;

import java.util.Scanner;

public class P07_MaxSequenceOfEqualNumbers {
    public static void main(String[] args) {

        int[] array = readArray();

        int currentSequenceCount = 1;
        int maxSequenceCount = 1;
        int maxRepeatedNumber = 0;

        for (int i = 0; i < array.length - 1; i++) {

            if (array[i] == array[i + 1]) {
                currentSequenceCount++;
                if (currentSequenceCount > maxSequenceCount) {
                    maxSequenceCount = currentSequenceCount;
                    maxRepeatedNumber = array[i];
                }
            } else {
                currentSequenceCount = 1;
            }
        }


    printResult(maxRepeatedNumber, maxSequenceCount);

}

    private static int[] readArray() {
        Scanner scanner = new Scanner(System.in);

        String[] splitArray = scanner.nextLine().split(" ");
        int[] array = new int[splitArray.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(splitArray[i]);
        }

        return array;
    }

    private static void printResult(int maxRepeatedNumber, int maxSequenceCount) {
        for (int i = 0; i < maxSequenceCount; i++) {
            System.out.print(maxRepeatedNumber);
            if (i != maxSequenceCount - 1) {
                System.out.print(" ");
            }
        }
    }

}
