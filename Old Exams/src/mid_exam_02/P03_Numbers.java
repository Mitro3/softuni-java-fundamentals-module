package mid_exam_02;

import java.util.*;
import java.util.stream.Collectors;

public class P03_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int sum = numList.stream().mapToInt((Integer::intValue)).sum();
        double averageValue = 1.0 * sum / numList.size();

        int countTopNumbers = 0;
        List<Integer> topNumberList = new ArrayList<>();

        for (int i = 0; i < numList.size(); i++) {

            if (numList.get(i) > averageValue) {
                countTopNumbers++;
                topNumberList.add(numList.get(i));
            }
        }

        if (topNumberList.size() == 0) {
            System.out.println("No");
            return;
        }

        Collections.sort(topNumberList);
        Collections.reverse(topNumberList);

        for (int i = 0; i < topNumberList.size(); i++) {
            if (i == 5) {
                break;
            }
                int currElement = topNumberList.get(i);
                System.out.print(currElement + " ");
        }

    }
}
