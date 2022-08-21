package more_exercises;
import java.util.Scanner;

public class P03_GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double initialBalance = Double.parseDouble(scanner.nextLine());

        double currentBalance = initialBalance;

        String input = scanner.nextLine();

        while (!input.equals("Game Time")) {
            double tempBalance = getBalance(currentBalance, input);


            if (tempBalance == 0) {
                printMovieName(input);
                System.out.println("Out of money!");
                return;
            } else if (tempBalance == -1) {
                System.out.println("Too Expensive");
            } else if (tempBalance == -2) {
                System.out.println("Not found");
            } else {
                printMovieName(input);
                currentBalance = tempBalance;
            }
            input = scanner.nextLine();
        }

        double totalSpent = initialBalance - currentBalance;
        System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpent, currentBalance);
    }

    private static double getBalance(double currentBalance, String input) {


        if (currentBalance == 0) {
            return 0;
        }

        switch (input) {
            case "OutFall 4":
                currentBalance -= 39.99;
                break;
            case "CS: OG":
                currentBalance -= 15.99;
                break;
            case "Zplinter Zell":
                currentBalance -= 19.99;
                break;
            case "Honored 2":
                currentBalance -= 59.99;
                break;
            case "RoverWatch":
                currentBalance -= 29.99;
                break;
            case "RoverWatch Origins Edition":
                currentBalance -= 39.99;
                break;
            default:
                return -2;
        }

        if (currentBalance < 0) {
            return -1;
        }

        return currentBalance;
    }

    private static void printMovieName(String input) {
        System.out.println("Bought " + input);
    }
}
