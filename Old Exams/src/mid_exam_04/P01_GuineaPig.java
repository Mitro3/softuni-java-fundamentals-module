package mid_exam_04;

import java.util.Scanner;

public class P01_GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double foodQuantity = Double.parseDouble(scanner.nextLine()) * 1000;
        double hayQuantity = Double.parseDouble(scanner.nextLine()) * 1000;
        double coverQuantity = Double.parseDouble(scanner.nextLine()) * 1000;
        double pigWeight = Double.parseDouble(scanner.nextLine()) * 1000;

        int daysCount = 0;
        while (daysCount < 30) {
            daysCount++;
            foodQuantity -= 300;

            if (daysCount % 2 == 0) {
                hayQuantity -= 0.05 * foodQuantity;
            }

            if (daysCount % 3 == 0) {
                coverQuantity -= pigWeight / 3;
            }

        }

        if (foodQuantity > 0 && hayQuantity > 0 && coverQuantity > 0) {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.", foodQuantity / 1000, hayQuantity / 1000, coverQuantity / 1000);
        } else {
            System.out.println("Merry must go to the pet store!");
        }
    }
}
