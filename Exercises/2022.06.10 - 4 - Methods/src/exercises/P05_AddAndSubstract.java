package exercises;

import java.util.Scanner;

public class P05_AddAndSubstract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstInt = scanner.nextInt();
        int secondInt = scanner.nextInt();
        int thirdInt = scanner.nextInt();

        int sumResult = sumIntegers(firstInt, secondInt);
        int subtractResult = subtract(sumResult, thirdInt);

        System.out.println(subtractResult);
    }

    private static int sumIntegers(int firstInt, int secondInt){
        int sum = firstInt + secondInt;

        return sum;
    }

    private static int subtract(int sum, int thirdInt){
        int result = sum - thirdInt;
        return result;
    }
}
