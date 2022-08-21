package more_exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P01_EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int stringsCount = scanner.nextInt();
        scanner.nextLine();

        int[] productArray = encryptArray(stringsCount, scanner);

        Arrays.sort(productArray);
        for (int element : productArray){
            System.out.println(element);
        }
    }

    private static int[] encryptArray(int stringsCount, Scanner scanner){
        int[] productArray = new int[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String input = scanner.nextLine();
            char[] currentArray = new char[input.length()];
            for (int j = 0; j < currentArray.length; j++) {
                currentArray[j] = input.charAt(j);
            }

            int product = 0;

            for (int k = 0; k < currentArray.length; k++) {
                switch (currentArray[k]){
                    case 'a':
                    case 'A':
                    case 'e':
                    case 'E':
                    case 'i':
                    case 'I':
                    case 'o':
                    case 'O':
                    case 'u':
                    case 'U':
                        product += currentArray[k] * input.length();
                        break;
                    default:
                        product += currentArray[k] / input.length();
                }
            }
            productArray[i] = product;
        }

        return productArray;
    }
}
