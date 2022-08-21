package exercises;

import java.util.Scanner;

public class P02_VowelsCount_v2{
    public static void main(String[] args) {


        int vowelsCount = countWordVowels();
        System.out.println(vowelsCount);
    }

    private static int countWordVowels(){
        Scanner scanner = new Scanner(System.in);
        char[] array = scanner.nextLine().toLowerCase().toCharArray();

        int counter = 0;
        for (int i = 0; i < array.length; i++) {

            switch (array[i]){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    counter++;
                    break;
            }
        }

        return counter;
    }
}
