import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P04_StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countMessages = Integer.parseInt(scanner.nextLine());
        String regex = "@(?<planetName>[A-Za-z]+)[^@!:>-]*:(?<population>\\d+)[^@!:>-]*!(?<attackType>[AD])![^@!:>-]*->(?<soldiersCount>\\d+)";
        Pattern pattern = Pattern.compile(regex);

        List<String> attackPlanets = new ArrayList<>();
        List<String> defendPlanets = new ArrayList<>();

        for (int i = 0; i < countMessages; i++) {
            String encryptedMessage = scanner.nextLine();
            String decryptedMessage = getDecryptedMessage(encryptedMessage);

            Matcher matcher = pattern.matcher(decryptedMessage);
            if (matcher.find()) {
                String planetName = matcher.group("planetName");
                int population = Integer.parseInt(matcher.group("population"));
                String attackType = matcher.group("attackType");
                int solidersCount = Integer.parseInt(matcher.group("soldiersCount"));

                if (attackType.equals("A")) {
                    attackPlanets.add(planetName);
                } else if (attackType.equals("D")) {
                    defendPlanets.add(planetName);
                }
            }
        }

        System.out.println("Attacked planets: " + attackPlanets.size());
        Collections.sort(attackPlanets);
        attackPlanets.forEach(planet -> System.out.println("-> " + planet));

        System.out.println("Destroyed planets: " + defendPlanets.size());
        Collections.sort(defendPlanets);
        defendPlanets.forEach(planet -> System.out.println("-> " + planet));
    }

    private static String getDecryptedMessage(String encryptedMessage) {
        int countLetters = getSpecialLettersCount(encryptedMessage);

        StringBuilder decryptedMessage = new StringBuilder();
        for (char symbol : encryptedMessage.toCharArray()) {
            char newSymbol = (char) (symbol - countLetters);
            decryptedMessage.append(newSymbol);
        }

        return decryptedMessage.toString();
    }

    private static int getSpecialLettersCount(String encryptedMessage) {
        int count = 0;
        for (char symbol : encryptedMessage.toCharArray()) {
            switch (symbol) {
                case 's':
                case 't':
                case 'a':
                case 'r':
                case 'S':
                case 'T':
                case 'A':
                case 'R':
                    count++;
                    break;
            }
        }
        return count;
    }
}
