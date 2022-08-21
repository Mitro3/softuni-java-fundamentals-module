package exercises;

import java.util.Scanner;

public class P07_VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputCoin = scanner.nextLine();
        double sum = 0;

        while (!inputCoin.equals("Start")) {
            double currentCoin = Double.parseDouble(inputCoin);

            if (currentCoin == 0.1 || currentCoin == 0.2 || currentCoin == 0.5 || currentCoin == 1 || currentCoin == 2) {
                sum += currentCoin;
            } else {
                System.out.printf("Cannot accept %.2f%n", currentCoin);
            }

            inputCoin = scanner.nextLine();
        }

        String drink = scanner.nextLine();

        while (!drink.equals("End")) {

            switch (drink) {
                case "Nuts":
                    if (sum < 2) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.println("Purchased " + drink);
                        sum -= 2;
                    }
                    break;
                case "Water":
                    if (sum < 0.7) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.println("Purchased " + drink);
                        sum -= 0.7;
                    }
                    break;
                case "Crisps":
                    if (sum < 1.5) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.println("Purchased " + drink);
                        sum -= 1.5;
                    }
                    break;
                case "Soda":
                    if (sum < 0.8) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.println("Purchased " + drink);
                        sum -= 0.8;
                    }
                    break;
                case "Coke":
                    if (sum < 1) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.println("Purchased " + drink);
                        sum -= 1;
                    }
                    break;
                default:
                    System.out.println("Invalid product");
            }

            drink = scanner.nextLine();

        }

        System.out.printf("Change: %.2f", sum);

    }
}
