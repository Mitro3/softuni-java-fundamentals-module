package exercises;

import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;


public class P04_ListOperations {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();
        while(!command.equals("End")){

            if (command.contains("Add")){
                int numberToAdd = Integer.parseInt(command.split(" ")[1]);
                numList.add(numberToAdd);

            } else if(command.contains("Insert")) {
                int numberToInsert = Integer.parseInt(command.split(" ")[1]);
                int index = Integer.parseInt(command.split(" ")[2]);

                if (isIndexValid(index, numList.size())) {
                    numList.add(index, numberToInsert);
                } else {
                    System.out.println("Invalid index");
                }

            } else if(command.contains("Remove")) {
                int indexToRemove = Integer.parseInt(command.split(" ")[1]);

                if (isIndexValid(indexToRemove, numList.size())) {
                    numList.remove(indexToRemove);
                } else {
                    System.out.println("Invalid index");
                }

            } else if(command.contains("Shift left")) {
                int countLeft = Integer.parseInt(command.split(" ")[2]);
                for (int time = 1; time <= countLeft; time++) {
                    numList.add(numList.get(0));
                    numList.remove(0);
                }

            } else if(command.contains("Shift right")) {
                int countRight = Integer.parseInt(command.split(" ")[2]);
                for (int time = 1; time <= countRight; time++) {
                    numList.add(0,
                            (numList.get(numList.size() - 1)));
                    numList.remove(numList.size() - 1);
                }
            }

            command = scanner.nextLine();
        }

        for (int element : numList) {
            System.out.print(element + " ");
        }

    }

    private static boolean isIndexValid(int index, int listSize) {
        return index >= 0 && index < listSize;
    }
}