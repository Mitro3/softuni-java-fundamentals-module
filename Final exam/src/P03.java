import java.util.*;

public class P03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> guestsMeals = new LinkedHashMap<>();
        int dislikedMealsCount = 0;

        String commandLine = scanner.nextLine();
        while (!commandLine.equals("Stop")) {
            String[] commandLineInfo = commandLine.split("-");
            String command = commandLineInfo[0];
            String guest = commandLineInfo[1];
            String meal = commandLineInfo[2];
            List<String> mealsList = new ArrayList<>();

            switch (command){
                case "Like":
                    if (!guestsMeals.containsKey(guest)) {
                        mealsList.add(meal);
                        guestsMeals.put(guest, mealsList);
                    } else {
                        mealsList = guestsMeals.get(guest);
                        if (!mealsList.contains(meal)) {
                            mealsList.add(meal);
                            guestsMeals.put(guest, mealsList);
                        }
                    }
                    break;

                case "Dislike":
                    if (!guestsMeals.containsKey(guest)) {
                        System.out.printf("%s is not at the party.%n", guest);
                    } else {
                        if (!guestsMeals.get(guest).contains(meal)) {
                            System.out.printf("%s doesn't have the %s in his/her collection.%n", guest, meal);
                        } else {
                            dislikedMealsCount++;
                            mealsList = guestsMeals.get(guest);
                            mealsList.remove(meal);
                            guestsMeals.put(guest, mealsList);

                            System.out.printf("%s doesn't like the %s.%n", guest, meal);
                        }
                    }
                    break;
            }
            commandLine = scanner.nextLine();
        }

        guestsMeals.entrySet().forEach(guest -> {
            System.out.printf("%s: ", guest.getKey());
            List<String> meals = guest.getValue();
            System.out.println(String.join(", ", meals));
        });

        System.out.println("Unliked meals: " + dislikedMealsCount);
    }
}
