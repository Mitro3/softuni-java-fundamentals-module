package mid_exam_retake_03;

import java.util.Arrays;
import java.util.Scanner;

public class P02_ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targets = readArray(scanner);
        int shotTargetsCount = 0;

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            int index = Integer.parseInt(input);

            if(isIndexValid(targets.length, index)) {
                shotTargetsCount++;
                int shotTargetValue = targets[index];
                targets[index] = -1;

                for (int i = 0; i < targets.length; i++) {

                    if (targets[i] > shotTargetValue && i != index && targets[i] != -1) {
                        targets[i] -= shotTargetValue;

                    } else if (targets[i] <= shotTargetValue && i != index && targets[i] != -1) {
                        targets[i] += shotTargetValue;
                    }
                }
            }

            input = scanner.nextLine();
        }

        printArray(targets, shotTargetsCount);
    }

    private static int[] readArray(Scanner scanner) {
        String input = scanner.nextLine();
        int[] array = Arrays.stream(input.split("\\s+")).mapToInt((Integer::parseInt)).toArray();

        return array;
    }

    private static boolean isIndexValid(int length, int index) {
        return index >= 0 && index < length;
    }

    private static void printArray(int[] targets, int shotTargetsCount) {
        System.out.printf("Shot targets: %d -> ", shotTargetsCount);
        for (int elements : targets) {
            System.out.print(elements + " ");
        }

    }
}
