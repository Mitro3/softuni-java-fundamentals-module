package exercises;

import java.util.Scanner;

public class P07_WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fillsCount = scanner.nextInt();
        int capacity = 255;
        int litersFilled = 0;

        for (int i = 0; i < fillsCount; i++) {
            int input = scanner.nextInt();
            capacity -= input;
            if (capacity < 0) {
                System.out.println("Insufficient capacity!");
                capacity += input;
                continue;
            }
            litersFilled += input;
        }

        System.out.println(litersFilled);
    }
}
