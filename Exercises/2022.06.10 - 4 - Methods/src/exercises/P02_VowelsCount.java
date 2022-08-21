package exercises;

import java.util.Scanner;

public class P02_VowelsCount{
    public static void main(String[] args) {


        int vowelsCount = countWordVowels();
        System.out.println(vowelsCount);
    }

    private static int countWordVowels(){
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        char[] wordArray = new char[word.length()];

        int counter = 0;
        for (int i = 0; i < word.length(); i++) {
            wordArray[i] = word.charAt(i);

            switch (wordArray[i]){
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
                    counter++;
                    break;
            }
        }

        return counter;
    }
}
