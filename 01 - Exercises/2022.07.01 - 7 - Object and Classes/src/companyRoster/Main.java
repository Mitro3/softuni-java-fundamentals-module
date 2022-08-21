package companyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfEmployees = Integer.parseInt(scanner.nextLine());

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < numberOfEmployees; i++) {
            String[] input = scanner.nextLine().split(" ");

            Employee currEmployee = new Employee();
            currEmployee.setName(input[0]);
            currEmployee.setSalary(Double.parseDouble(input[1]));
            currEmployee.setPosition(input[2]);
            currEmployee.setDepartment(input[3]);

            switch (input.length) {
                case 5:
                    if (input[4].contains("@")) {
                        currEmployee.setEmail(input[4]);
                    } else {
                        currEmployee.setAge(Integer.parseInt(input[4]));
                    }
                    break;

                case 6:
                    if (input[4].contains("@")) {
                        currEmployee.setEmail(input[4]);
                        currEmployee.setAge(Integer.parseInt(input[5]));
                    } else {
                        currEmployee.setAge(Integer.parseInt(input[4]));
                        currEmployee.setEmail(input[5]);
                    }
                    break;
            }

            employees.add(currEmployee);
        }

        List<String> departmentsList = employees.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());

        List<Department> departments = new ArrayList<>();

        for (String department : departmentsList) {
            departments.add(new Department(department,
                    employees.stream().filter(employee -> employee.getDepartment().equals(department)).collect(Collectors.toList())));
        }

        departments.sort(Comparator.comparingDouble(Department::getAverageSalary).reversed());
        Department department = departments.get(0);
        department.getEmployees().sort(Comparator.comparingDouble(Employee::getSalary).reversed());

        System.out.printf("Highest Average Salary: %s%n", department.getName());
        for (Employee employee : department.getEmployees()) {
            System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge());
        }
    }
}
