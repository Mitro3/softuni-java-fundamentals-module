package final_exam_03;

import java.util.Scanner;

public class P01_SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder concealedMessage = new StringBuilder(scanner.nextLine());

        String commandLine = scanner.nextLine();
        while (!commandLine.equals("Reveal")) {
            String[] commandLineInfo = commandLine.split(":\\|:");
            String command = commandLineInfo[0];

            switch (command){
                case "InsertSpace":
                    int index = Integer.parseInt(commandLineInfo[1]);
                    if (isValidIndex(index, concealedMessage)) {
                        concealedMessage.insert(index, " ");
                    }

                    System.out.println(concealedMessage);
                    break;

                case "Reverse":
                    String substringToSearch = commandLineInfo[1];
                    if (concealedMessage.toString().contains(substringToSearch)) {
                        int startIndex = concealedMessage.indexOf(substringToSearch);
                        int endIndex = startIndex + substringToSearch.length();
                        concealedMessage.delete(startIndex, endIndex);

                        StringBuilder substringBuilder = new StringBuilder(substringToSearch);
                        String reversedSubstring = substringBuilder.reverse().toString();
                        concealedMessage.append(reversedSubstring);

                        System.out.println(concealedMessage);

                    } else {
                        System.out.println("error");
                    }
                    break;

                case "ChangeAll":
                    String stringToReplace = commandLineInfo[1];
                    String replacementString = commandLineInfo[2];
                    String changedMessage = concealedMessage.toString().replace(stringToReplace, replacementString);
                    concealedMessage = new StringBuilder(changedMessage);

                    System.out.println(concealedMessage);
                    break;
            }

            commandLine = scanner.nextLine();
        }

        System.out.println("You have a new text message: " + concealedMessage);
    }

    private static boolean isValidIndex(int index, StringBuilder concealedMessage) {
        return index >= 0 && index < concealedMessage.length();
    }
}
