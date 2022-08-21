package more_exercises;
import java.util.Scanner;

public class P04_RefactoringPrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int endNumber = Integer.parseInt(scanner.nextLine());
        for (int startNumber = 2; startNumber <= endNumber; startNumber++) {
            boolean isPrime = true;
            for (int divider = 2; divider < startNumber; divider++) {
                if (startNumber % divider == 0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", startNumber, isPrime);
        }




    }
}
