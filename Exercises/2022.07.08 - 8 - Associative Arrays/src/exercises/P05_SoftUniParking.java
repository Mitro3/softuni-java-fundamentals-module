package exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05_SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> registrationMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String command = input.split("\\s+")[0];
            String username = input.split("\\s+")[1];

            switch (command) {
                case "register":
                    String licensePlate = input.split("\\s+")[2];

                    if (isUsernameRegister(username, registrationMap)) {
                        System.out.printf("ERROR: already registered with plate number %s%n", licensePlate);
                    } else {
                        registrationMap.put(username, licensePlate);
                        System.out.printf("%s registered %s successfully%n", username, licensePlate);
                    }
                    break;

                case "unregister":
                    if (!isUsernameRegister(username, registrationMap)) {
                        System.out.printf("ERROR: user %s not found%n", username);
                    } else {
                        System.out.printf("%s unregistered successfully%n", username);
                        registrationMap.remove(username);
                    }
                    break;
            }
        }

        registrationMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " => " + entry.getValue()));
    }

    private static boolean isUsernameRegister(String username, Map<String, String> registrationMap) {
        return registrationMap.containsKey(username);
    }
}
