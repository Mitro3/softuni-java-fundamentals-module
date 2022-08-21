package exercises;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10_SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> usernamesLanguagesCount = new LinkedHashMap<>();
        Map<String, Integer> usernamesPoints = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("exam finished")) {
            String[] splitData = input.split("-");
            String username = splitData[0];
            String userLanguage = splitData[1];

            if (splitData.length == 3) {
                int userPoints = Integer.parseInt(splitData[2]);

                usernamesPoints.putIfAbsent(username, userPoints);
                int currPoints = usernamesPoints.get(username);
                if (userPoints > currPoints) {
                    usernamesPoints.put(username, currPoints);
                }

                usernamesLanguagesCount.putIfAbsent(userLanguage, 0);
                int currLangCount = usernamesLanguagesCount.get(userLanguage);
                usernamesLanguagesCount.put(userLanguage, currLangCount + 1);

            } else {
                usernamesPoints.remove(username);
            }

            input = scanner.nextLine();
        }

//        System.out.println("Results:");
//        usernamesPoints.entrySet().stream()
//                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
//                        .thenComparing(Map.Entry.comparingByKey()))
//                .forEach(entry -> System.out.println(entry.getKey() + " | " + entry.getValue()));
//


        System.out.println("Results:");
        usernamesPoints.entrySet().forEach(entry -> System.out.println(entry.getKey() + " | " + entry.getValue()));

        System.out.println("Submissions:");
        usernamesLanguagesCount.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByKey().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
    }
}
