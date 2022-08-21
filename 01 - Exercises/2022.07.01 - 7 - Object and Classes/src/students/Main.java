package students;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String personalData = scanner.nextLine();
            String firstName = personalData.split(" ")[0];
            String lastName = personalData.split(" ")[1];
            double grade = Double.parseDouble(personalData.split(" ")[2]);

            Student currStudent = new Student(firstName, lastName, grade);
            studentList.add(currStudent);
        }

        studentList.sort(Comparator.comparingDouble(Student::getGrade).reversed());

        DecimalFormat df = new DecimalFormat("#.00");

        for (Student student : studentList) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + ": " + df.format(student.getGrade()));
        }
    }
}
