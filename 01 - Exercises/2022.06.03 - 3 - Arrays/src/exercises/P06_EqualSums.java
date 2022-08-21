package exercises;

import java.util.Scanner;

public class P06_EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = readArray(scanner);

        int result = checkEquality(array);

        if (result != -1) {
            System.out.println(result);
        } else {
            System.out.println("no");
        }
    }

    private static int[] readArray(Scanner scanner) {
        String[] stringArray = scanner.nextLine().split(" ");
        int[] array = new int[stringArray.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(stringArray[i]);
        }

        return array;
    }

    private static int checkEquality(int[] array) {
        if (array.length == 1) {
            return 0;
        }

        int rightSum = 0;
        for (int i = 0; i < array.length; i++) {
            rightSum += array[i];
        }

        int leftSum = 0;
        for (int i = 0; i < array.length; i++) {
            rightSum -= array[i];

            if (rightSum == leftSum){
                return i;
            }

            leftSum += array[i];
        }

        return -1;
    }
}
