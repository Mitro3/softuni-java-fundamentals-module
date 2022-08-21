import java.util.Scanner;

public class P02_TaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(">>");
        double totalRevenue = 0;

        for (int i = 0; i < input.length; i++) {
            String[] currInput = input[i].split("\\s+");
            String carType = currInput[0];
            int yearsCount = Integer.parseInt(currInput[1]);
            int kmTraveled = Integer.parseInt(currInput[2]);

            switch (carType) {
                case "family":
                    double familyCarTaxes = getFamilyTaxResult(yearsCount, kmTraveled);
                    System.out.printf("A family car will pay %.2f euros in taxes.%n", familyCarTaxes);
                    totalRevenue += familyCarTaxes;
                    break;

                case "heavyDuty":
                    double heavyDutyCarTaxes = getHeavyDutyTaxResult(yearsCount, kmTraveled);
                    System.out.printf("A heavyDuty car will pay %.2f euros in taxes.%n", heavyDutyCarTaxes);
                    totalRevenue += heavyDutyCarTaxes;
                    break;

                case "sports":
                    double sportsCarTaxes = getSportsTaxResult(yearsCount, kmTraveled);
                    System.out.printf("A sports car will pay %.2f euros in taxes.%n", sportsCarTaxes);
                    totalRevenue += sportsCarTaxes;
                    break;

                default:
                    System.out.println("Invalid car type.");
            }
        }

        System.out.printf("The National Revenue Agency will collect %.2f euros in taxes.", totalRevenue);

    }

    private static double getSportsTaxResult(int yearsCount, int kmTraveled) {
        return (kmTraveled / 2000) * 18  + (100 - yearsCount * 9);
    }

    private static double getHeavyDutyTaxResult(int yearsCount, int kmTraveled) {
        return (kmTraveled / 9000) * 14  + (80 - yearsCount * 8);
    }

    private static double getFamilyTaxResult(int yearsCount, int kmTraveled) {
        return (kmTraveled / 3000) * 12  + (50 - yearsCount * 5);
    }
}
