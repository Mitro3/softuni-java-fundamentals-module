package more_exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P05_KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lengthDNA = scanner.nextInt();
        scanner.nextLine();


        int bestSequenceCount = 0;
        int bestSequenceSum = 0;
        int bestSequenceIndex = 0;
        int bestSample = 0;
        int currentSample = 0;
        int[] bestArray = new int[lengthDNA];

        String input = scanner.nextLine();
        while (!input.equals("Clone them!")) {
            int[] arrayDNA = Arrays.stream(input.split("!")).mapToInt(Integer::parseInt).toArray();
            currentSample++;

            int currentSum = 0;
            int currentStartIndex = -1;
            int currentLength = 0;
            int currentLengthMax = 0;
            int currentPositionMax = -1;

            for (int i = 0; i < arrayDNA.length; i++) {
                if (arrayDNA[i] == 1) {
                    if (currentStartIndex == -1) {
                        currentStartIndex = i;
                    }
                    currentSum += arrayDNA[i];
                    currentLength++;
                }

                if ((arrayDNA[i] == 0) || (i == arrayDNA.length - 1)) {
                    if (currentLength > currentLengthMax) {
                        currentLengthMax = currentLength;
                        currentPositionMax = currentStartIndex;
                    }

                    currentLength = 0;
                    currentStartIndex = -1;
                }

                input = scanner.nextLine();
            }

            System.out.printf("Best DNA sample %d with sum %d%n", bestSample, bestSequenceSum);
            for (int element : bestArray) {
                System.out.print(element + " ");
            }
        }
    }
}
