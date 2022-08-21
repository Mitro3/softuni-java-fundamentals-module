import java.util.Arrays;
import java.util.Scanner;

public class P02_MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|");

        int health = 100;
        int bitcoins = 0;
        int currentRoom = 0;
        boolean isDead = false;

        for (int i = 0; i < input.length; i++) {

            String command = input[i].split(" ")[0];
            int commandNumber = Integer.parseInt(input[i].split(" ")[1]);

            switch (command) {
                case "potion":
                    health += commandNumber;
                    currentRoom++;

                    if (health > 100) {
                        commandNumber = Math.abs(health - 100 - commandNumber);
                        health = 100;

                    }

                    System.out.printf("You healed for %d hp.%n", commandNumber);
                    System.out.printf("Current health: %d hp.%n", health);

                    break;

                case "chest":
                    bitcoins += commandNumber;
                    currentRoom++;
                    System.out.printf("You found %d bitcoins.%n", commandNumber);
                    break;

                default:
                    health -= commandNumber;
                    currentRoom++;

                    if (health <= 0) {
                        isDead = true;
                        System.out.printf("You died! Killed by %s.%n", command);
                        System.out.println("Best room: " + currentRoom);
                    } else {
                        System.out.println("You slayed " + command + ".");
                    }
            }

            if(isDead) {
                break;
            }
        }

        if (!isDead) {
            System.out.println("You've made it!");
            System.out.println("Bitcoins: " + bitcoins);
            System.out.println("Health: " + health);
        }
    }
}
