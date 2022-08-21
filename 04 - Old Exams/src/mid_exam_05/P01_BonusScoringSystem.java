package mid_exam_05;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P01_BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsCount = Integer.parseInt(scanner.nextLine());
        int courseLectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());

        double maxBonus = 0;
        int maxLecturesAmount = 0;

        for (int i = 0; i < studentsCount; i++) {
            int currStudentAttendaces = Integer.parseInt(scanner.nextLine());
            double currBonus = 1.0 * currStudentAttendaces / courseLectures * (5 + additionalBonus);

            if(currBonus > maxBonus) {
                maxBonus = currBonus;
                maxLecturesAmount = currStudentAttendaces;
            }
        }
        maxBonus = Math.ceil(maxBonus);
        DecimalFormat df = new DecimalFormat("0");
        System.out.printf("Max Bonus: %s.%n", df.format(maxBonus));
        System.out.printf("The student has attended %d lectures.", maxLecturesAmount);

    }
}
