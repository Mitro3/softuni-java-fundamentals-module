package exercises;

import java.util.Scanner;

public class P01_IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstInteger = scanner.nextInt();
        int secondInteger = scanner.nextInt();
        int thirdInteger = scanner.nextInt();
        int fourthInteger = scanner.nextInt();

        int result = (firstInteger + secondInteger) / thirdInteger * fourthInteger;
        System.out.println(result);
    }
}
