package exercises;

import java.util.Scanner;

public class P11_RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGames = scanner.nextInt();
        double headsetPrice = scanner.nextDouble();
        double mousePrice = scanner.nextDouble();
        double keyboardPrice = scanner.nextDouble();
        double displayPrice = scanner.nextDouble();

        int headsetCount = lostGames / 2;
        int mouseCount = lostGames / 3;
        int keyboardCount = lostGames / 6;
        int displayCount = lostGames / 12;

        double totalPrice = headsetPrice * headsetCount + mouseCount * mousePrice + keyboardPrice * keyboardCount + displayPrice * displayCount;
        System.out.printf("Rage expenses: %.2f lv.", totalPrice);

    }

}
