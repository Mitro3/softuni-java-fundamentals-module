import java.util.Scanner;

public class P01_TheBiscuitFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int biscuitsPerDay = Integer.parseInt(scanner.nextLine());
        int workersCount = Integer.parseInt(scanner.nextLine());
        double competingFactoryProduct = Double.parseDouble(scanner.nextLine());
        int totalProduction = 0;

        for (int i = 1; i <= 30; i++) {
            double dailyProduction = biscuitsPerDay * workersCount;

            if (i % 3 == 0 ) {
                dailyProduction = Math.floor(dailyProduction * 0.75);
            }

            totalProduction += dailyProduction;
        }

        System.out.printf("You have produced %d biscuits for the past month.%n", totalProduction);

        double difference = Math.abs(totalProduction - competingFactoryProduct);

        if (totalProduction > competingFactoryProduct) {
            System.out.printf("You produce %.2f percent more biscuits.", difference / competingFactoryProduct * 100);
        } else if (totalProduction < competingFactoryProduct) {
            System.out.printf("You produce %.2f percent less biscuits.", difference / competingFactoryProduct * 100);
        }
    }
}
