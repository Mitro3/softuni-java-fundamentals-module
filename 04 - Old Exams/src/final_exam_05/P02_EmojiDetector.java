package final_exam_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String digitsRegex = "\\d";
        Pattern digitsPattern = Pattern.compile(digitsRegex);
        Matcher digitsMatcher = digitsPattern.matcher(input);

        long coolThreshold  = 1;

        while (digitsMatcher.find()) {
            int currDigit = Integer.parseInt(digitsMatcher.group());
            coolThreshold *= currDigit;
        }

        String emojiRegex = "(?<delimeter>([:]{2}|[*]{2}))(?<emoji>[A-Z][a-z]{2,})\\1";
        Pattern emojiPattern = Pattern.compile(emojiRegex);
        Matcher emojiMatcher = emojiPattern.matcher(input);

        List<String> coolEmojis = new ArrayList<>();
        int emojisCount = 0;

        while (emojiMatcher.find()) {
            emojisCount++;
            String currEmoji = emojiMatcher.group();

            int currEmojiThreshold = 0;
            for (int i = 2; i < currEmoji.length() - 2; i++) {
                int currCharAscii = currEmoji.charAt(i);
                currEmojiThreshold += currCharAscii;
            }

            if (currEmojiThreshold >= coolThreshold) {
                coolEmojis.add(currEmoji);
            }
        }

        System.out.println("Cool threshold: " + coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", emojisCount);
        coolEmojis.forEach(emoji -> System.out.println(emoji));

    }
}
