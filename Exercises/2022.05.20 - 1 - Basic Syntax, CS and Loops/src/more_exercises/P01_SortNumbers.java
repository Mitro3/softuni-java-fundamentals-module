package more_exercises;
import java.util.Scanner;

public class P01_SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        int[] array = readArray(num1, num2, num3);

        int[] orderedArray = orderDescArray(array);

        for (int i = 0; i < orderedArray.length; i++){
            System.out.println(orderedArray[i]);
        }

    }

    private static int[] readArray(int num1, int num2, int num3){
        int[] array = {num1, num2, num3};

        return array;
    }

    private static int[] orderDescArray(int[] array){

        for (int i = 0; i <= array.length - 1; i++) {

            int index = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[index] < array[j]) {
                    index = j;
                }
            }

            int biggerNumber = array[i];
            array[i] = array[index];
            array[index] = biggerNumber;
        }

        return array;
    }
}
