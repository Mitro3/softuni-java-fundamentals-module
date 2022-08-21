package more_exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P03_TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        String[] numString = input.replaceAll("[^0-9]", "").split("");
        List<String> numList = Arrays.asList(numString);

        String[] charString = input.replaceAll("[0-9]", "").split("");
        List<String> charList = Arrays.asList(charString);

        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();

        for (int i = 0; i < numList.size(); i++) {
            int currNum = Integer.parseInt(numList.get(i));

            if (i % 2 == 0) {
                takeList.add(currNum);
            } else {
                skipList.add(currNum);
            }

        }

        String result = "";
        String skipResult = "";
        int counter = 0;

        for (int i = 0; i < takeList.size(); i++) {
            int currTakeNum = takeList.get(i);
            int currSkipNum = skipList.get(i);

            if (counter + currTakeNum > charList.size()) {
                currTakeNum = charList.size() - counter;
            }

            for (int j = 0; j < currTakeNum; j++) {
                result += charList.get(counter + j);
            }

            counter += currTakeNum + currSkipNum;

        }

        System.out.println(result);

    }
}
