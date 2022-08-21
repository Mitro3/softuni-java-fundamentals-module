package exercises;

import java.util.Scanner;

public class P10_PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int power = scanner.nextInt();
        int distance = scanner.nextInt();
        int exhaustionFactor = scanner.nextInt();

        int currentPower = power;
        int countTargets = 0;

        while (currentPower >= distance){
            currentPower -= distance;
            countTargets++;

            if (currentPower == (50 * 1.00 / 100 * power)){
                if (exhaustionFactor > 0) {
                    currentPower /= exhaustionFactor;
                }
            }
        }

        System.out.println(currentPower);
        System.out.println(countTargets);


    }
}
