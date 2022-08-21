package mid_exam_retake_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P02_TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        int[] currentLiftStateArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int peopleCount = input;
        boolean isFull = false;
        boolean isEmpty = false;
        boolean boardingCompleted = false;

        List<String> names = new ArrayList<>();

        for (int i = 0; i < currentLiftStateArray.length; i++) {
            int currentWagon = currentLiftStateArray[i];

            if (peopleCount == 0) {
                isEmpty = true;
                break;
            }

            while (currentWagon < 4) {
                currentWagon++;
                peopleCount--;
                if (peopleCount <= 0) {
                    isEmpty = true;
                    break;
                }
            }

            currentLiftStateArray[i] = currentWagon;

            if (peopleCount > 0){
                isFull = true;
            }

            if (i == currentLiftStateArray.length - 1 && currentLiftStateArray[i] == 4){
                boardingCompleted = true;
            }
        }

        if (isEmpty && isFull && boardingCompleted) {
            for (int element :
                    currentLiftStateArray) {
                System.out.print(element + " ");
            }
        } else if (isEmpty) {
            System.out.println("The lift has empty spots!");
            for (int element :
                    currentLiftStateArray) {
                System.out.print(element + " ");
            }
        } else if (isFull) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleCount);
            for (int element :
                    currentLiftStateArray) {
                System.out.print(element + " ");
            }
        }

    }
}
