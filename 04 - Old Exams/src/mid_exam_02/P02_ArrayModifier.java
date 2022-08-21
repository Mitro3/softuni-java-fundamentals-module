package mid_exam_02;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class P02_ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = readArray(scanner);

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String command = input.split("\\s+")[0];

            switch (command) {
                case "swap":
                    int firstIndex = Integer.parseInt(input.split("\\s+")[1]);
                    int secondIndex = Integer.parseInt(input.split("\\s+")[2]);

                    swapArrayElements(array, firstIndex, secondIndex);
                    break;

                case "multiply":
                    firstIndex = Integer.parseInt(input.split("\\s+")[1]);
                    secondIndex = Integer.parseInt(input.split("\\s+")[2]);

                    multiplyArrayElements(array, firstIndex, secondIndex);
                    break;

                case "decrease":
                    decreaseAllArrayElements(array);
                    break;
            }

            input = scanner.nextLine();
        }

        printArray(array);

    }

    private static int[] readArray (Scanner scanner) {
        String input = scanner.nextLine();
        int[] array = Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        return array;
    }

    private static void swapArrayElements(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private static void multiplyArrayElements(int[] array, int firstIndex, int secondIndex) {
        array[firstIndex] *= array[secondIndex];
    }

    private static void decreaseAllArrayElements(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] -= 1;
        }
    }

    private static void printArray(int[] array) {
        String[] intArrayAsString = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            intArrayAsString[i] = String.valueOf(array[i]);
        }

        System.out.println(String.join(", ", intArrayAsString));
    }
}
