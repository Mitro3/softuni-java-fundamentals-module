package more_exercises;

import java.util.Scanner;

public class P02_PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        long[][] pascalTriangleArray = new long[rows][];

        for (int i = 0; i < rows; i++) {
            int elements = i + 1;

            pascalTriangleArray[i] = new long[elements];
            pascalTriangleArray[i][0] = 1;
            pascalTriangleArray[i][elements - 1] = 1;

            if (i > 1) {
                for (int col = 1; col < elements - 1; col++) {
                    pascalTriangleArray[i][col] = pascalTriangleArray[i - 1][col - 1] + pascalTriangleArray[i - 1][col];
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            for (int col = 0; col < pascalTriangleArray[i].length; col++) {
                if (col > 0){
                    sb.append(" ");
                }

                sb.append(pascalTriangleArray[i][col]);
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb.toString());


    }
}
