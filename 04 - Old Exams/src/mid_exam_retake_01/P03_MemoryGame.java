package mid_exam_retake_01;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> sequence = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String input = scanner.nextLine();
        int movesCount = 0;
        boolean isWon = false;

        while (!input.equals("end")) {
            movesCount++;
            int firstIndex = Integer.parseInt(input.split(" ")[0]);
            int secondIndex = Integer.parseInt(input.split(" ")[1]);

            if(isIndexValid(firstIndex, secondIndex, sequence.size())) {
                int middleIndex = sequence.size() / 2;
                sequence.add(middleIndex, String.format("-%sa", movesCount));
                sequence.add(middleIndex + 1, String.format("-%sa", movesCount));
                System.out.println("Invalid input! Adding additional elements to the board");
                input = scanner.nextLine();
                continue;
            }

            if (sequence.get(firstIndex).equals(sequence.get(secondIndex))) {
                System.out.printf("Congrats! You have found matching elements - %s!%n", sequence.get(firstIndex));
                sequence.remove(firstIndex);

                if (firstIndex > secondIndex) {
                    sequence.remove(secondIndex);
                } else if (firstIndex < secondIndex) {
                    sequence.remove(secondIndex - 1);
                }

            } else {
                System.out.println("Try again!");
            }

            if (sequence.size() == 0) {
                System.out.printf("You have won in %d turns!", movesCount);
                isWon = true;
                break;
            }

            input = scanner.nextLine();
        }

        if(!isWon) {
            System.out.println("Sorry you lose :(");

            for (String elements : sequence) {
                System.out.print(elements + " ");
            }
        }
    }

    private static boolean isIndexValid (int firstIndex, int secondIndex, int listSize) {
        return  (firstIndex == secondIndex || firstIndex < 0 || secondIndex < 0
            || firstIndex > listSize - 1 || secondIndex > listSize -1);
    }
}
