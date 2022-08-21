package exercises;

import java.util.*;

public class P06_Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> courseMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String course = input.split(" : ")[0];
            String student = input.split(" : ")[1];

            courseMap.putIfAbsent(course, new ArrayList<>());
            List<String> currStudents = courseMap.get(course);
            currStudents.add(student);
            courseMap.put(course, currStudents);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : courseMap.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
            List<String> currStudents = courseMap.get(entry.getKey());
            for (String student : currStudents) {
                System.out.printf("-- %s%n", student);
            }
        }

    }
}
