package exercises;

import java.util.Scanner;

public class P09_PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")){
            String reversedInput = reverseString(input);
            if (isPalindrome(input, reversedInput)){
                System.out.println(true);
            } else {
                System.out.println(false);
            }

            input = scanner.nextLine();
        }
    }
    
    private static String reverseString(String input){
        char currentChar;
        String reversedString = "";

        for (int i = 0; i < input.length(); i++) {
            currentChar = input.charAt(i);
            reversedString = currentChar + reversedString;
        }
        return reversedString;
    }

    private static boolean isPalindrome(String input, String reversedInput){
        boolean isPalindrome = false;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == reversedInput.charAt(i)){
                isPalindrome = true;
            } else {
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }
}
