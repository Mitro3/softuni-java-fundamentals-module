package more_exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P06_LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        int[] field = new int[fieldSize];

        int[] ladyBugsIndexes = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int ladyBugIndex : ladyBugsIndexes) {
            if (ladyBugIndex >= 0 && ladyBugIndex < field.length) {
                field[ladyBugIndex] = 1;
            }
        }

        System.out.println();
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] commands = command.split(" ");
            int index = Integer.parseInt(commands[0]);
            String direction = commands[1];
            int flyLength = Integer.parseInt(commands[2]);

            if (index >= 0 && index < field.length && field[index] == 1) {
                field[index] = 0;
                if (direction.equals("right")) {
                    index += flyLength;

                    while(index <= fieldSize - 1 && field[index] == 1){
                        index += flyLength;
                    }

                    if (index <= fieldSize - 1){
                        field[index] = 1;
                    }

                } else if (direction.equals("left")) {
                    index -= flyLength;

                    while(index >= 0 && field[index] == 1){
                        index -= flyLength;
                    }

                    if (index >= 0){
                        field[index] = 1;
                    }
                }
            }

            command = scanner.nextLine();
        }

        for (int number:
             field) {
            System.out.print(number + " ");
        }
    }
}
