import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P02_Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String names = scanner.nextLine();
        List<String> racersName = Arrays.stream(names.split(", "))
                .collect(Collectors.toList());
        Map<String, Integer> racersResults = new LinkedHashMap<>();
        racersName.forEach(name -> racersResults.put(name, 0));

        String regexLetters = "[A-Za-z]+";
        Pattern patternLetter = Pattern.compile(regexLetters);

        String regexDigis = "\\d";
        Pattern patternDigit = Pattern.compile(regexDigis);

        String input = scanner.nextLine();
        while (!input.equals("end of race")) {
            StringBuilder nameBuilder = new StringBuilder();
            Matcher matcherLetters = patternLetter.matcher(input);

            while (matcherLetters.find()) {
                nameBuilder.append(matcherLetters.group());
            }

            int distance = 0;
            Matcher matcherDigit = patternDigit.matcher(input);
            while (matcherDigit.find()) {
                distance += Integer.parseInt(matcherDigit.group());
            }

            String racerName = nameBuilder.toString();
            if (racersResults.containsKey(racerName)) {
                int currDistance = racersResults.get(racerName);
                racersResults.put(racerName, currDistance + distance);
            }

            input = scanner.nextLine();
        }

        List<String> firstThreeWinners = racersResults.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(entry -> entry.getKey()).collect(Collectors.toList());

        System.out.println("1st place: " + firstThreeWinners.get(0));
        System.out.println("2nd place: " + firstThreeWinners.get(1));
        System.out.println("3rd place: " + firstThreeWinners.get(2));
    }
}
