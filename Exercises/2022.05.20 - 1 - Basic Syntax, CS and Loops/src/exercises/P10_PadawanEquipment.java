package exercises;

import java.util.Scanner;

public class P10_PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double moneyAmount = Double.parseDouble(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        double lightsabersPrice = Double.parseDouble(scanner.nextLine());
        double robesPrice = Double.parseDouble(scanner.nextLine());
        double beltsPrice = Double.parseDouble(scanner.nextLine());

        int freeBelts = studentsCount / 6;
        double totalPrice = lightsabersPrice * Math.ceil(studentsCount * 1.10) + robesPrice * studentsCount + beltsPrice * (studentsCount - freeBelts);

        if (totalPrice <= moneyAmount){
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else {
            double difference = totalPrice - moneyAmount;
            System.out.printf("George Lucas will need %.2flv more.", difference);
        }
    }
}
