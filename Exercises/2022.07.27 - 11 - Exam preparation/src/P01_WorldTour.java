import java.util.Scanner;

public class P01_WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine();
        StringBuilder stopsBuilder = new StringBuilder(stops);

        String command = scanner.nextLine();
        while (!command.equals("Travel")) {
            if (command.contains("Add Stop")) {
                int index = Integer.parseInt(command.split(":")[1]);
                String stop = command.split(":")[2];

                if (isAddIndexValid(index, stopsBuilder.toString())) {
                    stopsBuilder.insert(index, stop);
                }

                System.out.println(stopsBuilder.toString());

            } else if (command.contains("Remove Stop")) {
                int startIndex = Integer.parseInt(command.split(":")[1]);
                int endIndex = Integer.parseInt(command.split(":")[2]);

                if (isRemoveIndexesValid(startIndex, endIndex,
                        stopsBuilder.toString())) {
                    stopsBuilder.delete(startIndex, endIndex + 1);
                }

                System.out.println(stopsBuilder.toString());

            } else if (command.contains("Switch")) {
                String stopToRemove = command.split(":")[1];
                String stopToAdd = command.split(":")[2];

                if (stopsBuilder.toString().contains(stopToRemove)) {
                    String updatedText = stopsBuilder.toString()
                            .replace(stopToRemove, stopToAdd);
                    stopsBuilder = new StringBuilder(updatedText);
                }

                System.out.println(stopsBuilder.toString());
            }

            command = scanner.nextLine();
        }

        System.out.println("Ready for world tour! Planned stops: "
                + stopsBuilder.toString());
    }

    private static boolean isRemoveIndexesValid(int startIndex, int endIndex, String toString) {
        return startIndex >= 0 && startIndex <= endIndex
                && endIndex < toString.length();
    }

    private static boolean isAddIndexValid(int index, String string) {
        return index >= 0 && index < string.length();
    }
}
