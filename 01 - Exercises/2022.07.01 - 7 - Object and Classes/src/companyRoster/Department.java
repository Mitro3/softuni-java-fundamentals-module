package companyRoster;

import java.util.List;

public class Department {
    public String name;
    public List<Employee> employees;
    public double averageSalary;

    public Department(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
        this.averageSalary = employees.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double getAverageSalary() {
        return averageSalary;
    }
}
