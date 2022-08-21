package exercises;

import java.util.Scanner;

public class P01_SmallestOfThreeNumbers {
    public static void main(String[] args) {

        int smallestNumber = getSmallestNumber();
        System.out.println(smallestNumber);
    }

    private static int getSmallestNumber() {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        int smallestNumber;

        if (firstNumber < secondNumber && firstNumber < thirdNumber){
            smallestNumber = firstNumber;
        } else if (secondNumber < thirdNumber){
            smallestNumber = secondNumber;
        } else {
            smallestNumber = thirdNumber;
        }

        return smallestNumber;
    }
}
