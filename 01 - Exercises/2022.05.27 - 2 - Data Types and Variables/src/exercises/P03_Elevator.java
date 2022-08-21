package exercises;

import java.util.Scanner;

public class P03_Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleAmount = scanner.nextInt();
        int elevatorCapacity = scanner.nextInt();

        int fullCoursesCount = peopleAmount / elevatorCapacity;
        int partialCoursePersons = 0;
        if (peopleAmount % elevatorCapacity != 0){
            partialCoursePersons++;
        }
        int totalCoursesCount = fullCoursesCount + partialCoursePersons;
        System.out.println(totalCoursesCount);

    }
}
