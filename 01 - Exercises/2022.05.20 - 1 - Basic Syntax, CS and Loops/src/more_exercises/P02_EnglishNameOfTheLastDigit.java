package more_exercises;
import java.util.Scanner;

public class P02_EnglishNameOfTheLastDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        String lastDigitName = getLastDigitName(num);
        System.out.println(lastDigitName);
    }

    private static String getLastDigitName(int num) {

        int lastDigit = num % 10;


        switch (lastDigit) {
            case 0:
                return "zero";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
        }

        return "Invalid number";
    }

}
