package exercises;

import java.util.Scanner;

public class P08_TriangleOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();

        for (int rows = 1; rows <= n; rows++){
            for (int col = 1; col <= rows; col++){
                System.out.print(rows + " ");
            }
            System.out.println();
        }

    }
}
