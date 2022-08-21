package exercises;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;


public class P01_Train {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> peoplePerWagon = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();
        while(!command.equals("end")) {

            if (command.contains("Add")) {
                int passengers = Integer.parseInt(command.split(" ")[1]);
                peoplePerWagon.add(passengers);

            } else {
                int passengersToAdd = Integer.parseInt(command);

                for (int index = 0; index < peoplePerWagon.size(); index++) {
                    int currPeopleInWagon = peoplePerWagon.get(index);
                    int emptySpace = maxCapacity - currPeopleInWagon - passengersToAdd;

                    if (emptySpace >= 0) {
                        peoplePerWagon.set(index, currPeopleInWagon + passengersToAdd);
                        break;
                    }
                }
            }

            command = scanner.nextLine();
        }

        for (int element : peoplePerWagon) {
            System.out.print(element + " ");
        }
    }
}
 