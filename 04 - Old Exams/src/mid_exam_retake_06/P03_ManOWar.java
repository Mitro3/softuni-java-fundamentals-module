package mid_exam_retake_06;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShip = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> warShip = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int maxHealth = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        boolean isWarshipBroken = false;
        boolean isPirateShipBroken = false;

        while (!input.equals("Retire")) {
            String command = input.split(" ")[0];

            switch (command) {
                case "Fire":
                    int fireIndex = Integer.parseInt(input.split(" ")[1]);

                    if (isWarShipIndexValid(warShip.size(), fireIndex)) {
                        int fireDamage = Integer.parseInt(input.split(" ")[2]);
                        reduceValueOfElement(warShip, fireIndex, fireDamage);

                        if (warShip.get(fireIndex) <= 0) {
                            isWarshipBroken = true;
                        }
                    }
                    break;

                case "Defend":
                    int startIndex = Integer.parseInt(input.split(" ")[1]);
                    int endIndex = Integer.parseInt(input.split(" ")[2]);

                    if (isPirateShipDefendIndexValid(pirateShip.size(), startIndex, endIndex)) {
                        int defendDamage = Integer.parseInt(input.split(" ")[3]);
                        reduceListValuesInRange(pirateShip, startIndex, endIndex, defendDamage);

                        for (int i = startIndex; i <= endIndex; i++) {
                            if (pirateShip.get(i) <= 0) {
                                isPirateShipBroken = true;
                            }
                        }
                    }
                    break;

                case "Repair":
                    int repairIndex = Integer.parseInt(input.split(" ")[1]);
                    if (isPirateShipRepairIndexValid(pirateShip.size(), repairIndex)) {
                        int health = Integer.parseInt(input.split(" ")[2]);
                        increaseListElement(pirateShip, repairIndex, health, maxHealth);
                    }
                    break;


                case "Status":
                    double minHealth = 0.2 * maxHealth;
                    int counter = 0;
                    for (int sectionHealth : pirateShip) {
                        if (sectionHealth < minHealth) {
                            counter++;
                        }
                    }

                    System.out.printf("%d sections need repair.%n", counter);
                    break;
            }

            if (isWarshipBroken) {
                System.out.println("You won! The enemy ship has sunken.");
                break;
            }

            if (isPirateShipBroken) {
                System.out.println("You lost! The pirate ship has sunken.");
                break;
            }

            input = scanner.nextLine();
        }

        if (!isPirateShipBroken && !isWarshipBroken) {
            int pirateShipSum = 0;
            for (int section : pirateShip) {
                pirateShipSum += section;
            }

            int warShipSum = 0;
            for (int section : warShip) {
                warShipSum += section;
            }

            System.out.printf("Pirate ship status: %d%n", pirateShipSum);
            System.out.printf("Warship status: %d", warShipSum);
        }
    }

    private static void increaseListElement(List<Integer> pirateShip, int repairIndex, int value, int maxValue) {
        int sectionHealth = pirateShip.get(repairIndex);
        if (sectionHealth + value <= maxValue) {
            pirateShip.set(repairIndex, sectionHealth + value);
        } else {
            pirateShip.set(repairIndex, maxValue);
        }
    }

    private static boolean isPirateShipRepairIndexValid(int size, int repairIndex) {
        return repairIndex >= 0 && repairIndex < size;
    }

    private static void reduceListValuesInRange(List<Integer> pirateShip, int startIndex, int endIndex, int value) {
        for (int i = startIndex; i <= endIndex; i++) {
            int sectionHealth = pirateShip.get(i) - value;
            pirateShip.set(i, sectionHealth);
        }
    }

    private static boolean isPirateShipDefendIndexValid(int size, int startIndex, int endIndex) {
        return startIndex >= 0 && endIndex < size;
    }

    private static void reduceValueOfElement(List<Integer> warShip, int index, int value) {
        warShip.set(index, warShip.get(index) - value);
    }

    private static boolean isWarShipIndexValid(int size, int index) {
        return index >= 0 && index < size;
    }
}
