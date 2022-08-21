package mid_exam_retake_06;

import java.util.Scanner;

public class P01_BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysCount = Integer.parseInt(scanner.nextLine());
        int plunderPerDay = Integer.parseInt(scanner.nextLine());
        int expectedPlunder = Integer.parseInt(scanner.nextLine());

        double totalPlunder = 0;

        for (int i = 1; i <= daysCount; i++) {
            totalPlunder += plunderPerDay;

            if (i % 3 == 0) {
                totalPlunder += 0.5 * plunderPerDay;
            }

            if (i % 5 == 0) {
                totalPlunder -= 0.3 * totalPlunder;
            }
        }

        if (totalPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", totalPlunder);
        } else {
            double percentageLeft = 100 - 100.0 * (expectedPlunder - totalPlunder) / expectedPlunder;
            System.out.printf("Collected only %.2f%% of the plunder.", percentageLeft);
        }
    }
}
