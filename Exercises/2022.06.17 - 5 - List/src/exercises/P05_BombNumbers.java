package exercises;

import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;


public class P05_BombNumbers {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String bombInfo = scanner.nextLine();
        int bomb = Integer.parseInt(bombInfo.split(" ")[0]);
        int power = Integer.parseInt(bombInfo.split(" ")[1]);
        int sum = 0;

        while (numList.contains(bomb)) {
            int elementIndex = numList.indexOf(bomb);

            int left = Math.max(0,elementIndex - power);
            int right = Math.min(elementIndex + power, numList.size() - 1);

            for (int i = right; i >= left; i--) {
                numList.remove(i);
            }
        }

        for (int element : numList) {
            sum += element;
        }

        System.out.println(sum);

    }
}

