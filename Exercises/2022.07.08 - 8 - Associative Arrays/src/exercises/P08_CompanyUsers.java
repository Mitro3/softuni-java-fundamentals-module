package exercises;

import java.util.*;

public class P08_CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companies = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String company = input.split(" -> ")[0];
            String employeeId = input.split(" -> ")[1];

            companies.putIfAbsent(company, new ArrayList<>());
            List<String> employees = companies.get(company);

            if(!employees.contains(employeeId)) {
                companies.get(company).add(employeeId);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : companies.entrySet()) {
            System.out.printf("%s%n", entry.getKey());
            List<String> currEmployees = companies.get(entry.getKey());
            for (String employee : currEmployees) {
                System.out.printf("-- %s%n", employee);
            }
        }
    }
}
