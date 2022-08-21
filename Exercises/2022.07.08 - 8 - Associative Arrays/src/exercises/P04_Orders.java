package exercises;

import java.util.*;

public class P04_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> products = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("buy")) {
            String product = input.split("\\s+")[0];
            double price = Double.parseDouble(input.split("\\s+")[1]);
            double quantity = Double.parseDouble(input.split("\\s+")[2]);

            if (!products.containsKey(product)) {
                products.put(product, new ArrayList<>());
                products.get(product).add(price);
                products.get(product).add(quantity);

            } else {
                List<Double> currPriceAndQuantity = products.get(product);
                double currQuantity = currPriceAndQuantity.get(1);
                currPriceAndQuantity.set(0, price);
                currPriceAndQuantity.set(1, currQuantity + quantity);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<Double>> entry : products.entrySet()) {
            String product = entry.getKey();
            double price = entry.getValue().get(0);
            double quantity = entry.getValue().get(1);
            double totalPrice = price * quantity;

            System.out.printf("%s -> %.2f%n", product, totalPrice);
        }

    }
}
