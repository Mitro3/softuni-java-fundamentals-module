package more_exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> timeList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        //29 13 9 0 13 0 21 0 14 82 12
        //0  1  2 3  4 5  6 7  8  9 10

        int finishIndex = timeList.size() / 2;
        double leftSum = 0;
        double rightSum = 0;

        for (int index = 0; index < finishIndex; index++) {
            int currElement = timeList.get(index);

            leftSum += currElement;

            if ((timeList.get(index + 1) == 0) && (index + 1 != finishIndex)) {
                leftSum *= 0.8;
            }
        }

        for (int index = timeList.size() - 1;  index > finishIndex; index--) {
            int currElement = timeList.get(index);

            rightSum += currElement;

            if ((timeList.get(index - 1) == 0) && (index - 1 != finishIndex)) {
                rightSum *= 0.8;
            }
        }

        if (leftSum < rightSum) {
            System.out.println("The winner is left with total time: " + leftSum);
        } else {
            System.out.println("The winner is right with total time: " + rightSum);
        }
    }
}
