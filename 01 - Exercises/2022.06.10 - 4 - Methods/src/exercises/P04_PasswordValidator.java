package exercises;

import java.util.Scanner;

public class P04_PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int minLenth = 6;
        int maxLenth = 10;

        validateInput(input, minLenth, maxLenth);

    }

    private static boolean validateLength(String input, int minLength, int maxLength){
        if (input.length() >= minLength && input.toCharArray().length <= maxLength) {
            return true;
        }

        return false;
    }

    private static boolean validateType(String input){
        boolean isValid = false;

        for (char element : input.toCharArray()) {
            if ((element >= 48 && element <= 57) || (element >= 65 && element <= 90)
                    || (element >=97 && element <= 122)){
                isValid = true;
            } else {
                isValid = false;
            }

            if(!isValid){
                break;
            }
        }

        return isValid;
    }

    private static boolean validateDigits(String input){
        int digitsCount = 0;

        for (char element : input.toCharArray()) {
            if ((element >= 48 && element <= 57)){
                digitsCount++;
            }
        }

        if(digitsCount >= 2){
            return true;
        }

        return false;
    }

    private static void validateInput(String input, int minLength, int maxLength){
        boolean isValidLength = validateLength(input, minLength, maxLength);
        boolean isValidType = validateType(input);
        boolean isValidDigits = validateDigits(input);

        if (isValidLength && isValidType && isValidDigits){
            System.out.println("Password is valid");
        }

        if(!isValidLength){
            System.out.println("Password must be between 6 and 10 characters");
        }

        if(!isValidType){
            System.out.println("Password must consist only of letters and digits");
        }

        if(!isValidDigits){
            System.out.println("Password must have at least 2 digits");
        }
    }
}
