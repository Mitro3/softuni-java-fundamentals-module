package moreExercises;

import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contests = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end of contests")) {
            String contest = input.split(":")[0];
            String password = input.split(":")[1];

            contests.put(contest, password);

            input = scanner.nextLine();
        }

        Map<String, LinkedHashMap<String, Integer>> usersPoints = new TreeMap<>();

        input = scanner.nextLine();
        while (!input.equals("end of submissions")) {
            String currContest = input.split("=>")[0];
            if (!contestIsValid(currContest, contests)) {
                input = scanner.nextLine();
                continue;
            }

            String currPass = input.split("=>")[1];
            if (!passwordIsValid(currPass, contests)) {
                input = scanner.nextLine();
                continue;
            }

            String currUsername = input.split("=>")[2];
            int currPoints = Integer.parseInt(input.split("=>")[3]);

            usersPoints.putIfAbsent(currUsername, new LinkedHashMap<>());

            if (!usersPoints.get(currUsername).containsKey(currContest)) {
                usersPoints.get(currUsername).put(currContest, currPoints);
            } else {
                usersPoints.get(currUsername).put(currContest,
                        Math.max(currPoints, usersPoints.get(currUsername).get(currContest)));
            }

            input = scanner.nextLine();
        }

        int totalSum = 0;
        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : usersPoints.entrySet()) {
            int currSum = user.getValue().values().stream().mapToInt(i -> i).sum();
            if (currSum > totalSum) {
                totalSum = currSum;
            }
        }


        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : usersPoints.entrySet()) {
            if (user.getValue().values().stream().mapToInt(i -> i).sum() == totalSum) {
                System.out.printf("Best candidate is %s with total %d points.%n", user.getKey(), totalSum);
            }
        }

        System.out.println("Ranking: ");
        usersPoints.forEach((key, value) -> {
            System.out.printf("%s%n", key);
            value.entrySet().stream().sorted((f,s) -> s.getValue() - f.getValue())
                    .forEach(i -> System.out.printf("#  %s -> %d%n", i.getKey(), i.getValue()));
        });

    }

    private static boolean passwordIsValid(String currPass, Map<String, String> contests) {
        return contests.containsValue(currPass);
    }

    private static boolean contestIsValid(String currContest, Map<String, String> contests) {
        return contests.containsKey(currContest);
    }
}
