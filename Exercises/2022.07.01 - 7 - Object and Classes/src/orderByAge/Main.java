package orderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String name = input.split(" ")[0];
            String id = input.split(" ")[1];
            int age = Integer.parseInt(input.split(" ")[2]);

            Person currPerson = new Person(name, id, age);
            personList.add(currPerson);

            input = scanner.nextLine();
        }

        personList.sort(Comparator.comparingInt(Person::getAge));

        for (Person persons : personList) {
            System.out.printf("%s with ID: %s is %d years old.%n", persons.getName(), persons.getId(), persons.getAge());
        }
    }
}
