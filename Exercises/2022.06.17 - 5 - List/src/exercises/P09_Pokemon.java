package exercises;

import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;


public class P09_Pokemon {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> distanceList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int sumRemoved = 0;
        while (distanceList.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());

            if (index < 0) {
                int firstElement = distanceList.get(0);
                int lastElement = distanceList.get(distanceList.size() - 1);
                sumRemoved += firstElement;
                distanceList.set(0, lastElement);
                modifyList(distanceList, firstElement);

            } else if (index > distanceList.size() - 1) {
                int firstElement = distanceList.get(0);
                int lastElement = distanceList.get(distanceList.size() - 1);
                sumRemoved += lastElement;
                distanceList.set(distanceList.size() - 1, firstElement);
                modifyList(distanceList, lastElement);

            } else if (index >= 0 && index <= distanceList.size() - 1) {
                int removedElement = distanceList.get(index);
                sumRemoved += removedElement;
                distanceList.remove(index);
                modifyList(distanceList, removedElement);
            }
        }

        System.out.println(sumRemoved);

    }

    private static void modifyList(List<Integer> list,
                                   int removedElement) {
        for (int i = 0; i < list.size(); i++) {
            int currentElement = list.get(i);

            if (currentElement <= removedElement) {
                currentElement += removedElement;
            } else {
                currentElement -= removedElement;
            }

            list.set(i, currentElement);
        }
    }
}
