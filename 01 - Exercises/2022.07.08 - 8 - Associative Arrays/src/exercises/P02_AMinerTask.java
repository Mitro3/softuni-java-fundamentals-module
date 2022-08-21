package exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02_AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resourseMap = new LinkedHashMap<>();

        String resource = scanner.nextLine();
        while (!resource.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());

            resourseMap.putIfAbsent(resource, 0);
            int currQuantity = resourseMap.get(resource);
            resourseMap.put(resource, currQuantity + quantity);

            resource = scanner.nextLine();
        }

        resourseMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
