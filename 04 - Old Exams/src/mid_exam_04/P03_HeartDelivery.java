package mid_exam_04;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> housesHearths = Arrays.stream(scanner.nextLine().split("@"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int jumpLength = 0;
        String command = scanner.nextLine();

        while (!command.equals("Love!")) {
            int houseNumber = Integer.parseInt(command.split(" ")[1]);
            jumpLength += houseNumber;

            if (jumpLength > housesHearths.size() - 1) {
                jumpLength = 0;
            }

            int currHouseHearths = housesHearths.get(jumpLength);

            if (currHouseHearths == 0) {
                System.out.printf("Place %d already had Valentine's day.%n", jumpLength);
                command = scanner.nextLine();
                continue;
            }

            currHouseHearths -= 2;
            housesHearths.set(jumpLength, currHouseHearths);

            if (housesHearths.get(jumpLength) == 0) {
                System.out.printf("Place %d has Valentine's day.%n", jumpLength);
            }

            command = scanner.nextLine();
        }

        boolean isFailed = false;
        int failsCount = 0;

        for (int i = 0; i < housesHearths.size(); i++) {
            if (housesHearths.get(i) > 0) {
                failsCount++;
                isFailed = true;
            }
        }

        if (isFailed) {
            System.out.printf("Cupid's last position was %d.%n", jumpLength);
            System.out.printf("Cupid has failed %d places.", failsCount);
        } else {
            System.out.printf("Cupid's last position was %d.%n", jumpLength);
            System.out.println("Mission was successful.");
        }
    }
}
