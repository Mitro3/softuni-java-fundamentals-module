import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String regex = "[!](?<command>[A-Z][a-z]{2,})[!][:][\\[](?<text>[A-Za-z]{8,})[\\]]";
        Pattern pattern = Pattern.compile(regex);
        List<String> asciiNumbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String command = matcher.group("command");
                String stringToTranslate = matcher.group("text");

                for (int j = 0; j < stringToTranslate.length(); j++) {
                    int currCharAsciiCode = stringToTranslate.charAt(j);
                    asciiNumbers.add(currCharAsciiCode + " ");
                }

                System.out.printf("%s: ", command);
                asciiNumbers.forEach(symbol -> System.out.print(String.join(" ", symbol)));
                System.out.println();
            } else {
                System.out.println("The message is invalid");
            }

        }
    }
}
