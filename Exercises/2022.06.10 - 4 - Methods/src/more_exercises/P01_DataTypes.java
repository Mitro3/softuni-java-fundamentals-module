package more_exercises;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class P01_DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputType = scanner.nextLine();
        switch (inputType){
            case "int":
                int num = scanner.nextInt();
                int intResult = modifyInput(num);
                System.out.println(intResult);
                break;
            case "real":
                double number = scanner.nextDouble();
                String doubleResult = modifyInput(number);
                System.out.println(doubleResult);
                break;
            case "string":
                String input = scanner.nextLine();
                String stringResult = modifyInput(input);
                System.out.println(stringResult);
                break;
        }
    }

    private static int modifyInput(int num) {
        return num * 2;
    }

    private static String modifyInput(double num) {
        NumberFormat formatter = new DecimalFormat("0.00");
        return formatter.format(num * 1.5);
    }

    private static String modifyInput(String input) {
        String result = "$" + input + "$";
        return result;
    }

}
