package mid_exam_04;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> groceriesList = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Go Shopping!")) {
            String command = input.split(" ")[0];

            switch (command) {
                case "Urgent":
                    String urgentItem = input.split(" ")[1];
                    addElementToList(groceriesList, urgentItem);
                    break;

                case "Unnecessary":
                    String unnecessaryItem = input.split(" ")[1];
                    removeElementFromList(groceriesList, unnecessaryItem);
                    break;

                case "Correct":
                    String oldItem = input.split(" ")[1];
                    String newItem = input.split(" ")[2];
                    correctList(groceriesList, oldItem, newItem);
                    break;

                case "Rearrange":
                    String item = input.split(" ")[1];
                    rearrangeList(groceriesList, item);
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(String.join(", ", groceriesList));
    }

    private static void rearrangeList(List<String> groceriesList, String item) {
        if (groceriesList.contains(item)) {
            int itemIndex = groceriesList.indexOf(item);
            String tempItem = groceriesList.get(itemIndex);
            groceriesList.remove(itemIndex);
            groceriesList.add(tempItem);
        }
    }

    private static void correctList(List<String> groceriesList, String oldItem, String newItem) {
        if (groceriesList.contains(oldItem)) {
            int oldItemIndex = groceriesList.indexOf(oldItem);
            groceriesList.set(oldItemIndex, newItem);
        }
    }

    private static void removeElementFromList(List<String> groceriesList, String unnecessaryItem) {
        groceriesList.remove(unnecessaryItem);
    }

    private static void addElementToList(List<String> groceriesList, String urgentItem) {
        if (!groceriesList.contains(urgentItem)) {
            groceriesList.add(0, urgentItem);
        }
    }
}
