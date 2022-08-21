package mid_exam_retake_03;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("End")) {
            String command = commandLine.split(" ")[0];
            int index = Integer.parseInt(commandLine.split(" ")[1]);

            switch (command) {
                case "Shoot":
                    if (isIndexValid(index, targets.size())) {
                        int power = Integer.parseInt(commandLine.split(" ")[2]);
                        int currTarget = targets.get(index);
                        int targetHealth = currTarget - power;

                        if (targetHealth <= 0) {
                            targets.remove(index);
                        } else {
                            targets.set(index, targetHealth);
                        }
                    }

                    break;

                case "Add":
                    if (isIndexValid(index, targets.size())) {
                        int value = Integer.parseInt(commandLine.split(" ")[2]);
                        targets.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }

                    break;

                case "Strike":
                    int radius = Integer.parseInt(commandLine.split(" ")[2]);

                    if (isRadiusInRange(index, radius, targets.size())) {
                        int leftRadius = index - radius;
                        int rightRadius = index + radius;

                        for (int i = rightRadius; i >= leftRadius; i--) {
                            targets.remove(i);
                        }

                    } else {
                        System.out.println("Strike missed!");
                    }

                    break;
            }

            commandLine = scanner.nextLine();
        }

        for (int i = 0; i < targets.size(); i++) {
            System.out.print(targets.get(i));

            if (i != targets.size() - 1) {
                System.out.print("|");
            }
        }
    }

    private static boolean isIndexValid(int index, int listSize) {
        return index >= 0 && index < listSize;
    }

    private static boolean isRadiusInRange(int index, int radius, int listSize) {
        return index - radius >= 0 && index + radius < listSize - 1;
    }

}
