package exercises;

import java.util.Scanner;

public class P08_BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int kegsAmount = scanner.nextInt();
        scanner.nextLine();

        double biggestKegVolume = Double.MIN_VALUE;
        String biggestKegModel = "";

        for (int i = 0; i < kegsAmount; i++) {
            String kegModel = scanner.nextLine();
            double kegRadius = scanner.nextDouble();
            int kegHeight = scanner.nextInt();
            scanner.nextLine();

            double kegVolume = Math.PI * Math.pow(kegRadius, 2) * kegHeight;

            if (kegVolume > biggestKegVolume){
                biggestKegVolume = kegVolume;
                biggestKegModel = kegModel;
            }
        }

        System.out.println(biggestKegModel);
    }
}
