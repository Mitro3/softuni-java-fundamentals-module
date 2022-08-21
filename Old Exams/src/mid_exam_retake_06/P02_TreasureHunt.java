package mid_exam_retake_06;

import java.util.Scanner;

public class P02_TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] treasureChest = scanner.nextLine().split("\\|");

        String[] treasureArray = resultArray(scanner, treasureChest);

        String treasureCount = String.join("", treasureArray);
        int charCounter = 0;
        for (int i = 0; i < treasureCount.length(); i++) {
            charCounter++;
        }
        double averageTreasure = (1.0 * charCounter) / treasureChest.length;
        if (charCounter > 0){
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageTreasure);
        } else {
            System.out.println("Failed treasure hunt.");
        }

    }

    private static String[] resultArray(Scanner scanner, String[] treasureChest) {
        String input = scanner.nextLine();

        while (!input.equals("Yohoho!")) {
            String[] treasureFound = input.split(" ");

            switch (treasureFound[0]) {
                case "Loot":
                    for (int i = 1; i < treasureFound.length; i++) {
                        boolean alreadyContained = false;

                        for (int j = 0; j < treasureChest.length; j++) {
                            if (treasureFound[i].equals(treasureChest[j])) {
                                alreadyContained = true;
                                break;
                            }
                        }

                        if (!alreadyContained) {
                            String newChest = treasureFound[i] + " " + String.join(" ", treasureChest);
                            treasureChest = newChest.split(" ");
                        }
                    }
                    break;

                case "Drop":
                    int itemPosition = Integer.parseInt(treasureFound[1]);

                    if ((itemPosition < treasureChest.length) && (itemPosition >= 0)) {
                        String dropItem = treasureChest[itemPosition];

                        for (int i = itemPosition; i < treasureChest.length - 1; i++) {
                            treasureChest[i] = treasureChest[i + 1];
                        }
                        treasureChest[treasureChest.length - 1] = dropItem;

                    } else {
                        break;
                    }
                    break;

                case "Steal":
                    int stealItemsAmount = Integer.parseInt(treasureFound[1]);

                    if ((stealItemsAmount >= 0) && (stealItemsAmount < treasureChest.length)) {
                        for (int i = 0; i < stealItemsAmount; i++) {
                            System.out.print(treasureChest[treasureChest.length - stealItemsAmount + i]);
                            if (i != stealItemsAmount - 1) {
                                System.out.print(", ");
                            }
                        }

                        String[] tempChest = new String[treasureChest.length - stealItemsAmount];
                        for (int i = 0; i < tempChest.length; i++) {
                            tempChest[i] = treasureChest[i];
                        }
                        treasureChest = tempChest;

                    } else if (stealItemsAmount >= 0) {
                        for (int i = 0; i < treasureChest.length; i++) {
                            System.out.print(treasureChest[i]);

                            if (i != treasureChest.length - 1) {
                                System.out.print(", ");
                            }
                        }
                        treasureChest = new String[0];
                    }
                    System.out.println();
                    break;
            }
            input = scanner.nextLine();

        }

        return treasureChest;
    }
}
