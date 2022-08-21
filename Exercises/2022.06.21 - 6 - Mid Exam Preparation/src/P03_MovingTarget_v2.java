import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_MovingTarget_v2 {
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
                    int value = Integer.parseInt(commandLine.split(" ")[2]);

                    if (isRadiusInRange(index, value, targets.size())) {
                        int radius = value * 2 + 1;

                        for (int i = 0; i < radius; i++) {
                            targets.remove(index - value);
                        }

                    } else {
                        System.out.println("Strike missed!");
                    }

                    break;
            }

            commandLine = scanner.nextLine();
        }

        List<String> resultList = new ArrayList<>();
        for (int target : targets) {
            resultList.add(String.valueOf(target));
        }

        System.out.println(String.join("|", resultList));
    }

    private static boolean isIndexValid(int index, int listSize) {
        return index >= 0 && index < listSize;
    }

    private static boolean isRadiusInRange(int index, int radius, int listSize) {
        return index - radius >= 0 && index + radius < listSize - 1;
    }
}
