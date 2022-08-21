package more_exercises;
import java.util.Scanner;

public class P06_BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int linesNumber = scanner.nextInt();
        scanner.nextLine();

        int openCount = 0;
        int closeCount = 0;

        for (int i = 1; i <= linesNumber; i++) {
            String input = scanner.nextLine();

            if (input.equals("(")){
                openCount++;
            } else if (input.equals(")")){
                closeCount++;
                if (openCount - closeCount != 0){
                    System.out.println("UNBALANCED");
                    return;
                }
            }
        }

        if (openCount == closeCount){
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
