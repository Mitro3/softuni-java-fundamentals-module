package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P09_ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = readArray(scanner);

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] inputLine = input.split(" ");

            switch (inputLine[0]) {
                case "swap":
                    int firstIndex = Integer.parseInt(inputLine[1]);
                    int secondIndex = Integer.parseInt(inputLine[2]);

                    swapArrayIndices(array, firstIndex, secondIndex);
                    break;

                case "multiply":
                    firstIndex = Integer.parseInt(inputLine[1]);
                    secondIndex = Integer.parseInt(inputLine[2]);

                    multiplyIndices(array, firstIndex, secondIndex);
                    break;

                case "decrease":
                    decreaseElements(array);
                    break;
            }

            input = scanner.nextLine();
        }

        printArray(array);

    }


    private static int[] readArray(Scanner scanner) {
        String input = scanner.nextLine();
        int[] array = Arrays.stream(input.split(" ")).mapToInt((Integer::parseInt)).toArray();

        return array;
    }

    private static void swapArrayIndices(int[] array, int firstIndex, int secondIndex) {
        int tempNum = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tempNum;
    }

    private static void multiplyIndices(int[] array, int firstIndex, int secondIndex) {
        array[firstIndex] *= array[secondIndex];
    }

    private static void decreaseElements(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] -= 1;
        }
    }

    private static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }
    }
}
