package mid_exam_05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> journal = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Craft!")) {
            String command = input.split(" ")[0];

            switch (command) {
                case "Collect":
                    String itemToCollect = input.split(" ")[2];
                    addElementToList(journal, itemToCollect);
                    break;

                case "Drop":
                    String itemToDrop = input.split(" ")[2];
                    dropElementFromList(journal, itemToDrop);
                    break;

                case "Combine":
                    String items = input.split(" ")[3];
                    String oldItem = items.split(":")[0];
                    String newItem = items.split(":")[1];
                    combineElement(journal, oldItem, newItem);
                    break;

                case "Renew":
                    String itemToRenew = input.split(" ")[2];
                    renewList(journal, itemToRenew);
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(String.join(", ", journal));

    }

    private static void renewList(List<String> journal, String itemToRenew) {
        if (journal.contains(itemToRenew)) {
            int itemIndex = journal.indexOf(itemToRenew);
            String temp = journal.get(itemIndex);
            journal.remove(itemIndex);
            journal.add(temp);
        }
    }

    private static void combineElement(List<String> journal, String oldItem, String newItem) {
        if (journal.contains(oldItem)) {
            int oldItemIndex = journal.indexOf(oldItem);
            journal.add( oldItemIndex + 1, newItem);
        }
    }

    private static void dropElementFromList(List<String> journal, String itemToDrop) {
        journal.remove(itemToDrop);
    }

    private static void addElementToList(List<String> journal, String itemToCollect) {
        if (!journal.contains(itemToCollect)) {
            journal.add(itemToCollect);
        }
    }
}
