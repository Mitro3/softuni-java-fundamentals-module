package final_exam_04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String barcodeRegex = "[@][#]+(?<product>[A-Z][A-Za-z0-9]{4,}[A-Z])[@][#]+";
        Pattern pattern = Pattern.compile(barcodeRegex);

        for (int i = 0; i < n; i++) {
            String barcode = scanner.nextLine();

            Matcher matcher = pattern.matcher(barcode);
            if (matcher.find()) {
                String productGroupRegex = "(\\d)";
                Pattern digitsPattern = Pattern.compile(productGroupRegex);
                Matcher digitsMatcher = digitsPattern.matcher(barcode);
                StringBuilder currBarcodeDigits = new StringBuilder();

                while (digitsMatcher.find()) {
                    currBarcodeDigits.append(digitsMatcher.group());
                }

                if (currBarcodeDigits.length() == 0) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.println("Product group: " + currBarcodeDigits);
                }

            } else {
                System.out.println("Invalid barcode");
            }

        }

        System.out.println();
    }
}
