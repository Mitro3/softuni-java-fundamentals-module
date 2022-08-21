
import java.util.Scanner;

public class P01_ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double sum = 0;

        while (!input.equals("special") && !input.equals("regular")) {
            double currentPartPrice = Double.parseDouble(input);

            if (currentPartPrice < 0) {
                System.out.println("Invalid price!");
                input = scanner.nextLine();
                continue;
            }

            sum += currentPartPrice;
            input = scanner.nextLine();
        }

        double taxes = sum * 0.2;
        double totalPrice = sum + taxes;

        if (input.equals("special")) {
            totalPrice = totalPrice * 0.9;
        }
        if (sum > 0) {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", sum);
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", totalPrice);
        } else {
            System.out.println("Invalid order!");
        }
    }
}
