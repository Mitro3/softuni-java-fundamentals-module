package more_exercises;

import java.util.Scanner;

public class P03_LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstLineX1 = scanner.nextInt();
        int firstLineY1 = scanner.nextInt();
        int firstLineX2 = scanner.nextInt();
        int firstLineY2 = scanner.nextInt();

        int secondLineX1 = scanner.nextInt();
        int secondLineY1 = scanner.nextInt();
        int secondLineX2 = scanner.nextInt();
        int secondLineY2 = scanner.nextInt();

        double firstLineLength = getLineLength(firstLineX1, firstLineY1, firstLineX2, firstLineY2);
        double secondLineLength = getLineLength(secondLineX1, secondLineY1, secondLineX2, secondLineY2);

        if (firstLineLength >= secondLineLength){
            printClosestToCenterPoint(firstLineX1, firstLineY1, firstLineX2, firstLineY2);
        } else {
            printClosestToCenterPoint(secondLineX1, secondLineY1, secondLineX2, secondLineY2);
        }
    }

    private static double getLineLength(int x1, int y1, int x2, int y2){
        double lineLength = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

        return lineLength;
    }

    private static void printClosestToCenterPoint(int x1, int y1, int x2, int y2){
        int firstPointDiff = Math.abs(x1) + Math.abs(y1);
        int secondPointDiff = Math.abs(x2) + Math.abs(y2);

        if(firstPointDiff < secondPointDiff){
            int xClosestPoint = x1;
            int yClosestPoint = y1;
            System.out.printf("(%d, %d)", x1, y1);
            System.out.printf("(%d, %d)", x2, y2);
        } else {
            int xClosestPoint = x2;
            int yClosestPoint = y2;
            System.out.printf("(%d, %d)", x2, y2);
            System.out.printf("(%d, %d)", x1, y1);
        }
    }
}
