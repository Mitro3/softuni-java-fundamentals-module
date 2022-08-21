package final_exam_04;

import java.util.Scanner;

public class P01_PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        StringBuilder newPassword = new StringBuilder();

        String commandLine = scanner.nextLine();
        while (!commandLine.equals("Done")) {
            String[] commandLineData = commandLine.split("\\s");
            String command = commandLineData[0];

            switch (command) {
                case "TakeOdd":
                    for (int i = 1; i < password.length(); i += 2) {
                        char currChar = password.charAt(i);
                        newPassword.append(currChar);
                    }
                    password = newPassword.toString();

                    System.out.println(password);
                    break;

                case "Cut":
                    int index = Integer.parseInt(commandLineData[1]);
                    int length = Integer.parseInt(commandLineData[2]);

                    if (isValidIndex(index, length, password)) {
                        password = new StringBuilder(password).delete(index, index + length).toString();
                    }

                    System.out.println(password);
                    break;

                case "Substitute":
                    String substringToReplace = commandLineData[1];
                    String substitutionString = commandLineData[2];

                    if (password.toString().contains(substringToReplace)) {
                        password = password.replace(substringToReplace, substitutionString);

                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }

            commandLine = scanner.nextLine();
        }

        System.out.println("Your password is: " + password);
    }

    private static boolean isValidIndex(int index, int length, String password) {
        return index >= 0 && index + length <= password.length();
    }
}
