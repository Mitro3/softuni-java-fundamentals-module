package more_exercises;
import java.util.Scanner;

public class P03_FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNumber = scanner.nextDouble();
        double secondNumber = scanner.nextDouble();

        double eps = 0.000001;

        double difference = Math.abs(firstNumber - secondNumber);
        if (difference < eps){
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }
}
