package final_exam_05;

import java.util.Scanner;

public class P01_ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String data = scanner.nextLine();
        StringBuilder activationKey = new StringBuilder(data);

        String input = scanner.nextLine();
        while (!input.equals("Generate")) {
            String command = input.split(">>>")[0];
            switch (command){
                case "Contains":
                    String substring = input.split(">>>")[1];
                    if (activationKey.toString().contains(substring)) {
                        System.out.printf("%s contains %s%n", activationKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;

                case "Flip":
                    String caseToChange = input.split(">>>")[1];
                    int startIndexToFlip= Integer.parseInt(input.split(">>>")[2]);
                    int endIndexToFlip = Integer.parseInt(input.split(">>>")[3]);
                    String substringToFlip = activationKey.substring(startIndexToFlip, endIndexToFlip);

                    String flippedSubstring = "";
                    switch (caseToChange) {
                        case "Upper":
                            flippedSubstring = substringToFlip.toUpperCase();
                            break;
                        case "Lower":
                            flippedSubstring = substringToFlip.toLowerCase();
                            break;
                    }

                    activationKey.replace(startIndexToFlip, endIndexToFlip, flippedSubstring);
                    System.out.println(activationKey);
                    break;

                case "Slice":
                    int startIndexToDelete = Integer.parseInt(input.split(">>>")[1]);
                    int endIndexToDelete = Integer.parseInt(input.split(">>>")[2]);
                    activationKey.delete(startIndexToDelete, endIndexToDelete);
                    System.out.println(activationKey);
                    break;

            }

            input = scanner.nextLine();
        }

        System.out.println("Your activation key is: " + activationKey);
    }
}
