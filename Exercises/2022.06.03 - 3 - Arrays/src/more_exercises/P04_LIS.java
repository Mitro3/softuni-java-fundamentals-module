package more_exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P04_LIS {
    public static void main(String[] args) {

        int maxSequenceCount = 0;
        int maxSequenceLastIndex = 0;

        int[] array = readArray();

        int[] len = new int[array.length];
        int[] prev = new int[array.length];

        for (int i = 0; i < array.length; i++) {

            len[i] = 1;
            prev[i] = -1;

            for (int j = 0; j < i; j++) {
                if (array[j] < array[i] && len[j] + 1 > len[i]){
                    len[i] = len[j] + 1;
                    prev[i] = j;
                }
            }

            if (len[i] > maxSequenceCount)
            {
                maxSequenceCount = len[i];
                maxSequenceLastIndex = i;
            }
        }

        int[] LIS = new int[maxSequenceCount];
        int currentIndex = maxSequenceCount - 1;

        while (maxSequenceLastIndex != -1)
        {
            LIS[currentIndex] = array[maxSequenceLastIndex];
            currentIndex--;
            maxSequenceLastIndex = prev[maxSequenceLastIndex];
        }

        for (int i = 0; i < LIS.length; i++) {
            System.out.print(LIS[i] + " ");
        }

    }

    private static int[] readArray(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] array = Arrays.stream(input.split(" ")).mapToInt((Integer::parseInt)).toArray();

        return array;
    }

    private static void printArray(int[] array, int startIndex, int endIndex){
        for (int i = startIndex; i <= endIndex ; i++) {
            System.out.print(array[i]);
        }
    }
}
