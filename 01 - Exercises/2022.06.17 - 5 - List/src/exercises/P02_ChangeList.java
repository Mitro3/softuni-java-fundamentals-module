package exercises;

import java.util.Scanner;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;


public class P02_ChangeList {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();
        while(!command.equals("end")){
            List<String> commandLine = Arrays.stream(command.split(" "))
                    .collect(Collectors.toList());

            if (commandLine.get(0).equals("Delete")) {
                int element = Integer.parseInt(commandLine.get(1));
                numList.removeAll(Arrays.asList(element));
            } else if (commandLine.get(0).equals("Insert")) {
                int element = Integer.parseInt(commandLine.get(1));
                int position = Integer.parseInt(commandLine.get(2));
                numList.add(position, element);
            }

            command = scanner.nextLine();
        }

        for (int element : numList) {
            System.out.print(element + " ");
        }
    }
}
