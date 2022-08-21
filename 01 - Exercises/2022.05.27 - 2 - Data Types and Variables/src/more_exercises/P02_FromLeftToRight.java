package more_exercises;
import java.util.Scanner;

public class P02_FromLeftToRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsAmount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < rowsAmount; i++) {
            String input = scanner.nextLine();

            String[] arrString = input.split(" ");

            long leftNumber = Long.parseLong(arrString[0]);
            long rightNumber = Long.parseLong(arrString[1]);

            int sum = 0;
            if (leftNumber > rightNumber){

                while (leftNumber != 0){
                    long lastDigit = leftNumber % 10;
                    sum += lastDigit;
                    leftNumber /= 10;
                }
            } else {

                while (rightNumber != 0){
                    long lastDigit = rightNumber % 10;
                    sum += lastDigit;
                    rightNumber /= 10;
                }
            }
            System.out.println(Math.abs(sum));
        }


    }
}
