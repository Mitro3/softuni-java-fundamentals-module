import java.util.Scanner;

public class P01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String initialString = scanner.nextLine();

        String commandLine = scanner.nextLine();
        while (!commandLine.equals("Done")) {
            String[] commandLineData = commandLine.split("\\s");
            String command = commandLineData[0];
            String updatedString = "";

            switch (command) {
                case "Change":
                    String charToReplace = commandLineData[1];
                    String replacementChar = commandLineData[2];

                    updatedString = initialString.replace(charToReplace, replacementChar);
                    initialString = updatedString;
                    System.out.println(initialString);
                    break;

                case "Includes":
                    String substringToInclude = commandLineData[1];

                    if (initialString.contains(substringToInclude)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;

                case "End":
                    String substringToEnd = commandLineData[1];

                    if (initialString.endsWith(substringToEnd)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;

                case "Uppercase":
                    updatedString = initialString.toUpperCase();
                    initialString = updatedString;
                    System.out.println(initialString);
                    break;

                case "FindIndex":
                    String charToFind = commandLineData[1];
                    int index = initialString.indexOf(charToFind);
                    System.out.println(index);
                    break;

                case "Cut":
                    int startIndex = Integer.parseInt(commandLineData[1]);
                    int count = Integer.parseInt(commandLineData[2]);

                    updatedString = initialString.substring(startIndex, startIndex + count);
                    System.out.println(updatedString);
                    break;

            }

            commandLine = scanner.nextLine();
        }

    }
}
