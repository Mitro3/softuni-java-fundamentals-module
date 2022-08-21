package exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P10_SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> schedule = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("course start")) {
            String command = input.split(":")[0];
            String lessonTitle = input.split(":")[1];

            switch (command) {
                case "Add":
                    if (!schedule.contains(lessonTitle)) {
                        schedule.add(lessonTitle);
                    }
                    break;

                case "Insert":
                    int index = Integer.parseInt(input.split(":")[2]);

                    if (!schedule.contains(lessonTitle)) {
                        schedule.add(index, lessonTitle);
                    }
                    break;

                case "Remove":
                    schedule.remove(lessonTitle);
                    schedule.remove(lessonTitle + "-Exercise");
                    break;

                case "Swap":
                    String secondLessonTitle = input.split(":")[2];

                    if (schedule.contains(lessonTitle) && schedule.contains(secondLessonTitle)) {
                        String firstLessonTitle = lessonTitle;
                        int firstLessonIndex = schedule.indexOf(lessonTitle);
                        int secondLessonIndex = schedule.indexOf(secondLessonTitle);

                        schedule.set(firstLessonIndex, secondLessonTitle);
                        schedule.set(secondLessonIndex, firstLessonTitle);

                        if (schedule.contains(firstLessonTitle + "-Exercise")) {
                            schedule.remove(firstLessonTitle + "-Exercise");
                            schedule.add(secondLessonIndex + 1, (firstLessonTitle + "-Exercise"));

                        }
                        if (schedule.contains(secondLessonTitle + "-Exercise")) {
                            schedule.remove(secondLessonTitle + "-Exercise");
                            schedule.add(firstLessonIndex + 1, (secondLessonTitle + "-Exercise"));
                        }
                    }
                    break;

                case "Exercise":
                    if (!schedule.contains(lessonTitle)) {
                        schedule.add(lessonTitle);
                        schedule.add(lessonTitle + "-Exercise");

                    } else {
                        if (!schedule.contains(lessonTitle + "-Exercise")) {
                            int lessonIndex = schedule.indexOf(lessonTitle);
                            schedule.add(lessonIndex + 1, lessonTitle + "-Exercise");
                        }
                    }

                    break;
            }

            input = scanner.nextLine();
        }

        for (int i = 0; i < schedule.size(); i++) {
            System.out.printf("%s.%s%n", i + 1, schedule.get((i)));
        }
    }
}
