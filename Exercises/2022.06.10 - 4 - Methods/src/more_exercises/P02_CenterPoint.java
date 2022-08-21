package more_exercises;

import java.util.Scanner;

public class P02_CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        printClosestToCenterPoint(x1, y1, x2, y2);
    }

    private static void printClosestToCenterPoint(int x1, int y1, int x2, int y2){
        int firstPointDiff = Math.abs(x1) + Math.abs(y1);
        int secondPointDiff = Math.abs(x2) + Math.abs(y2);

        if(firstPointDiff <= secondPointDiff){
            int xClosestPoint = x1;
            int yClosestPoint = y1;
            System.out.printf("(%d, %d)", x1, y1);
        } else {
            int xClosestPoint = x2;
            int yClosestPoint = y2;
            System.out.printf("(%d, %d)", x2, y2);
        }
    }
}
