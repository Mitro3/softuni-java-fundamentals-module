package exercises;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class P03_HouseParty {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int commandsCount = Integer.parseInt(scanner.nextLine());
        List<String> guestsNames = new ArrayList();

        while (commandsCount > 0) {
            String command = scanner.nextLine();
            String currName = command.split(" ")[0];
            boolean isFound = false;

            if (!command.split(" ")[2].equals("not")) {
                for (int i = 0; i < guestsNames.size(); i++) {
                    if (currName.equals(guestsNames.get(i))) {
                        isFound = true;
                        System.out.printf("%s is already in the list!%n", currName);
                        break;
                    }
                }

                if (!isFound) {
                    guestsNames.add(currName);
                }

            } else {
                for (int i = 0; i < guestsNames.size(); i++) {
                    if (currName.equals(guestsNames.get(i))) {
                        guestsNames.remove(i);
                        isFound = true;
                        break;
                    }
                }

                if (!isFound) {
                    System.out.printf("%s is not in the list!%n", currName);
                }
            }

            commandsCount--;
        }

        for (String element : guestsNames) {
            System.out.println(element);
        }
    }
}

