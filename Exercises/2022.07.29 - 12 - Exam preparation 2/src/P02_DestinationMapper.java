import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "([=\\/])(?<destination>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> validDestination = new ArrayList<>();
        int travelPoints = 0;
        while (matcher.find()) {
            String currValidDestination = matcher.group("destination");
            travelPoints += currValidDestination.length();
            validDestination.add(currValidDestination);
        }

        System.out.print("Destinations: ");
        System.out.println(String.join(", ", validDestination));
        System.out.printf("Travel Points: %d%n", travelPoints);
    }
}
