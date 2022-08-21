package exercises;

import java.util.Scanner;

public class P02_CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] firstArray = readArray(scanner);
        String[] secondArray = readArray(scanner);

        printSameElements(firstArray,secondArray);

    }

    private static String[] readArray(Scanner scanner){

        String[] array = scanner.nextLine().split(" ");

        return array;
    }

    private static void printSameElements(String[] firstArray, String[] secondArray){
        for (int i = 0; i < secondArray.length; i++) {
            for (int j = 0; j < firstArray.length; j++) {
                if (secondArray[i].equals(firstArray[j])){
                    System.out.print(secondArray[i] + " ");
                    break;
                }
            }

        }
    }
}
