package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P05_TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //за всеки един елемент от масива -> проверка дали е топ
        for (int index = 0; index < numbers.length; index++) {
            int currentNumber = numbers[index];
            //винаги елементът на последния индекс ни е топ
            if (index == numbers.length - 1) {
                System.out.print(currentNumber + " ");
                break;
            }
            //обхождам всички индекси след моя
            //следващото число -> index + 1
            boolean isTop = false;
            for (int i = index + 1; i < numbers.length; i++) {
                int nextNumber = numbers[i];
                if (currentNumber > nextNumber) {
                    isTop = true;
                } else {
                    isTop = false;
                    break;
                }
            }
            //проверка дали моето число е топ
            if (isTop) {
                System.out.print(currentNumber + " ");
            }
        }
    }
}