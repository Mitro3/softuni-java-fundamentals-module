package exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06_CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (firstDeck.size() > 0 && secondDeck.size() > 0) {
                int firstPlayerCard = firstDeck.get(0);
                int secondPlayerCard = secondDeck.get(0);
                firstDeck.remove(0);
                secondDeck.remove(0);

                if (firstPlayerCard > secondPlayerCard) {
                        firstDeck.add(firstPlayerCard);
                        firstDeck.add(secondPlayerCard);

                } else if (firstPlayerCard < secondPlayerCard) {
                        secondDeck.add(secondPlayerCard);
                        secondDeck.add(firstPlayerCard);
                }
        }

        int sum = 0;
        if (secondDeck.size() == 0) {
            for (int element : firstDeck) {
                sum += element;
            }
            System.out.println("First player wins! Sum: " + sum);

        } else {
            for (int element : secondDeck) {
                sum += element;
            }
            System.out.println("Second player wins! Sum: " + sum);
        }

    }

}


