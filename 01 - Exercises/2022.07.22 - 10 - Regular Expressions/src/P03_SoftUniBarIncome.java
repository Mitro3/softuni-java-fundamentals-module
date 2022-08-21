import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03_SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "%(?<customerName>[A-z][a-z]+)%[^|$%.]*<(?<productName>\\w+)>[^|$%.]*\\|(?<quantity>\\d+)\\|[^|$%.\\d]*(?<price>\\d+.?\\d*)\\$";
        Pattern pattern = Pattern.compile(regex);

        double totalSum = 0;

        String input = scanner.nextLine();
        while(!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String customerName = matcher.group("customerName");
                String productName = matcher.group("productName");
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double price = Double.parseDouble(matcher.group("price"));

                double totalPrice = quantity * price;
                totalSum += totalPrice;

                System.out.printf("%s: %s - %.2f%n", customerName, productName, totalPrice);

            }

            input = scanner.nextLine();
        }

        System.out.printf("Total income: %.2f", totalSum);
    }
}
