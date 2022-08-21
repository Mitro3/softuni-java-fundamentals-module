package more_exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        List<String> input = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());
        String output = "";

        for (int i = 0; i < numList.size(); i++) {
            int currNum = Integer.parseInt(numList.get(i));

            int currSum = 0;
            while (currNum > 0) {
                int currDigit = currNum % 10;
                currSum += currDigit;
                currNum = currNum / 10;
            }

            if (currSum > input.size() - 1) {
                currSum -= input.size();
            }

            output += input.get(currSum);
            input.remove(currSum);
        }

        System.out.println(output);
    }
}
