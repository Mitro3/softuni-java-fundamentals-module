package final_exam_01;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "(?<delimeter>[\\|#])(?<product>[A-Za-z\\s]+)\\1(?<date>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>[0-9]|[1-9][0-9]|[1-9][0-9][0-9]|[1-9][0-9][0-9][0-9]|10000)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<List<String>> productsList = new ArrayList<>();

        int totalCalories = 0;
        while (matcher.find()) {
            String currProdName = matcher.group("product");
            String currExpDate = matcher.group("date");
            String currCalories = matcher.group("calories");

            totalCalories += Integer.parseInt(currCalories);

            productsList.add(List.of(currProdName, currExpDate, currCalories));
        }

        System.out.printf("You have food to last you for: %d days!%n", totalCalories / 2000);
        productsList.forEach(prod ->
                System.out.printf("Item: %s, Best before: %s, " +
                                "Nutrition: %s%n",
                        prod.get(0), prod.get(1),prod.get(2)));
    }
}
