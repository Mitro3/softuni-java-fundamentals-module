package exercises;

import java.util.Scanner;

public class P03_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleAmount = scanner.nextInt();
        scanner.nextLine();
        String groupType = scanner.nextLine();
        String weekday = scanner.nextLine();

        double totalPrice = getPrice(groupType, weekday, peopleAmount);

        System.out.printf("Total price: %.2f", totalPrice);

}

    private static double getStudentsPrice(String weekday) {

        switch (weekday) {
            case "Friday":
                return  8.45;
            case "Saturday":
                return  9.80;
            case "Sunday":
                return 10.46;
            default:
                return 0;
        }
    }

    private static double getBusinessPrice(String weekday) {
        double singlePrice = 0;

        switch (weekday) {
            case "Friday":
                singlePrice = 10.90;
                break;
            case "Saturday":
                singlePrice = 15.60;
                break;
            case "Sunday":
                singlePrice = 16;
        }

        return singlePrice;
    }

    private static double getRegularPrice(String weekday) {
        double singlePrice = 0;

        switch (weekday) {
            case "Friday":
                singlePrice = 15;
                break;
            case "Saturday":
                singlePrice = 20;
                break;
            case "Sunday":
                singlePrice = 22.50;
        }

        return singlePrice;
    }

    private static double getStudentsDiscount(int peopleAmount) {
        if (peopleAmount >= 30) {
            return 0.85;
        }
        return 1;
    }

    private static double getBusinessDiscount(int peopleAmount) {
        if (peopleAmount >= 100) {
            return ((peopleAmount - 10) * 1.00 / peopleAmount);
        }
        return 1;
    }

    private static double getRegularDiscount(int peopleAmount) {
        if (peopleAmount >= 10 && peopleAmount <= 20) {
            return 0.95;
        }
        return 1;
    }

    private static double getPrice(String groupType, String weekday, int peopleAmount){
        double singlePrice = 0;

        switch (groupType) {
            case "Students":
                singlePrice = getStudentsPrice(weekday);
                return (singlePrice * getStudentsDiscount(peopleAmount) * peopleAmount);
            case "Business":
                singlePrice = getBusinessPrice(weekday);
                return (singlePrice * getBusinessDiscount(peopleAmount) * peopleAmount);
            case "Regular":
                singlePrice = getRegularPrice(weekday);
                return (singlePrice * getRegularDiscount(peopleAmount) * peopleAmount);
            default:
                return 0;
        }
    }
}
