package mid_exam_02;

import java.util.Scanner;

public class P01_SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployeeRate = Integer.parseInt(scanner.nextLine());
        int secondEmployeeRate = Integer.parseInt(scanner.nextLine());
        int thirdEmployeeRate = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());

        int totalRatePerHour = firstEmployeeRate + secondEmployeeRate + thirdEmployeeRate;

        int hourCounter = 0;
        while (studentsCount > 0) {
            hourCounter++;

            if (hourCounter % 4 == 0) {
                continue;
            }

            studentsCount -= totalRatePerHour;

        }

        System.out.printf("Time needed: %dh.", hourCounter);
    }
}
