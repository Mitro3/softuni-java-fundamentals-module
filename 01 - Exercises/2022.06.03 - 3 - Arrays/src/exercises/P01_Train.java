package exercises;

import java.util.Scanner;

public class P01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vagonsCount = scanner.nextInt();

        int sum = 0;
        int[] array = new int[vagonsCount];

        for (int i = 0; i < vagonsCount; i++) {
            array[i] = scanner.nextInt();
            sum += array[i];
        }

        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println(sum);
    }
}
