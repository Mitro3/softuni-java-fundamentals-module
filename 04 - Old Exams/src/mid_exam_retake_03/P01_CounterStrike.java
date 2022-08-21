package mid_exam_retake_03;

import java.util.Scanner;

public class P01_CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());

        int battlesWon = 0;
        String input = scanner.nextLine();
        boolean isOutOfEnergy = false;

        while (!input.equals("End of battle")) {
            int currDistance = Integer.parseInt(input);

            if (currDistance > energy || energy < 0) {
                isOutOfEnergy = true;
                break;
            }

            energy -= currDistance;
            battlesWon++;

            if (battlesWon % 3 == 0) {
                energy += battlesWon;
            }

            input = scanner.nextLine();
        }

        if (!isOutOfEnergy) {
            System.out.printf("Won battles: %d. Energy left: %d", battlesWon, energy);
        } else {
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", battlesWon, energy);
        }
    }
}
