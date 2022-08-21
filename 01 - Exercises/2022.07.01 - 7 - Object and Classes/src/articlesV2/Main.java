package articlesV2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Article> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String title = input.split(", ")[0];
            String content = input.split(", ")[1];
            String author = input.split(", ")[2];

            Article currArticle = new Article(title, content, author);
            list.add(currArticle);
        }

        String command = scanner.nextLine();

        switch (command) {
            case "title":
            case "content":
            case "author":
                for (Article articles : list) {
                    System.out.println(articles.toString());
                }
        }
    }
}
