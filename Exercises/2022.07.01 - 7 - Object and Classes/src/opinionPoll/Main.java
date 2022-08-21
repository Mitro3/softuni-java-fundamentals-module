package opinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> personAbove30Years = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String name = input.split(" ")[0];
            int age = Integer.parseInt(input.split(" ")[1]);

            if (age > 30) {
                Person currPerson = new Person(name, age);
                personAbove30Years.add(currPerson);
            }
        }

        for (Person persons : personAbove30Years) {
            System.out.println(persons.getName() + " - " + persons.getAge());
        }
    }
}
