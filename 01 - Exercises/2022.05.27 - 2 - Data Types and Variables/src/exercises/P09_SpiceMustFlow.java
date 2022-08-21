package exercises;

import java.util.Scanner;

public class P09_SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = scanner.nextInt();

        int totalYield = 0;
        int countDays = 0;

        while (startingYield >= 100) {
            int spiceYield = startingYield - 26;
            totalYield += spiceYield;
            countDays++;
            startingYield -= 10;
        }

            totalYield -= 26;

        if (totalYield > 0) {
            System.out.println(countDays);
            System.out.println(totalYield);
        } else {
            System.out.println(0);
            System.out.println(0);
        }
    }

}
