package final_exam_04;

import java.util.*;

public class P03_HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> heroesMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String currHeroInfo = scanner.nextLine();
            String heroName = currHeroInfo.split("\\s")[0];
            int healthPoints = Integer.parseInt(currHeroInfo.split("\\s")[1]);
            int manaPoints = Integer.parseInt(currHeroInfo.split("\\s")[2]);

            List<Integer> heroInfo = new ArrayList<>();
            heroInfo.add(healthPoints);
            heroInfo.add(manaPoints);

            heroesMap.put(heroName, heroInfo);
        }

        String commandLine = scanner.nextLine();
        while (!commandLine.equals("End")) {
            String[] commandLineInfo = commandLine.split(" - ");
            String command = commandLineInfo[0];
            String heroName = commandLineInfo[1];

            List<Integer> currHeroInfo = heroesMap.get(heroName);
            int updatedHealthPoints = 0;
            int updatedManaPoints = 0;

            switch (command){
                case "CastSpell":
                    int manaPointsNeeded = Integer.parseInt(commandLineInfo[2]);
                    String spellName = commandLineInfo[3];

                    if (manaPointsNeeded <= heroesMap.get(heroName).get(1)) {
                        updatedManaPoints = currHeroInfo.get(1) - manaPointsNeeded;
                        currHeroInfo.set(1, updatedManaPoints);
                        heroesMap.put(heroName, currHeroInfo);

                        System.out.printf("%s has successfully cast %s and now has %d MP!%n",
                                heroName, spellName, updatedManaPoints);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;

                case "TakeDamage":
                    int damage = Integer.parseInt(commandLineInfo[2]);
                    String attacker = commandLineInfo[3];

                    if (damage < heroesMap.get(heroName).get(0)) {
                       updatedHealthPoints = currHeroInfo.get(0) - damage;
                        currHeroInfo.set(0, updatedHealthPoints);
                        heroesMap.put(heroName, currHeroInfo);

                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                                heroName, damage, attacker, updatedHealthPoints);
                    } else {
                        heroesMap.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    }
                    break;

                case "Recharge":
                    int rechargeAmount = Integer.parseInt(commandLineInfo[2]);
                    if (currHeroInfo.get(1) + rechargeAmount > 200) {
                        updatedManaPoints = 200;
                        rechargeAmount = 200 - currHeroInfo.get(1);
                    } else {
                        updatedManaPoints = currHeroInfo.get(1) + rechargeAmount;
                    }

                    currHeroInfo.set(1, updatedManaPoints);
                    heroesMap.put(heroName, currHeroInfo);
                    System.out.printf("%s recharged for %d MP!%n", heroName, rechargeAmount);
                    break;

                case "Heal":
                    int healAmount = Integer.parseInt(commandLineInfo[2]);
                    if (currHeroInfo.get(0) + healAmount > 100) {
                        updatedHealthPoints = 100;
                        healAmount = 100 - currHeroInfo.get(0);
                    } else {
                        updatedHealthPoints = currHeroInfo.get(0) + healAmount;
                    }

                    currHeroInfo.set(0, updatedHealthPoints);
                    heroesMap.put(heroName, currHeroInfo);
                    System.out.printf("%s healed for %d HP!%n", heroName, healAmount);
                    break;
            }

            commandLine = scanner.nextLine();
        }

        heroesMap.entrySet().forEach(hero -> {
            System.out.println(hero.getKey());
            System.out.printf("  HP: %d%n", hero.getValue().get(0));
            System.out.printf("  MP: %d%n", hero.getValue().get(1));
        });
    }
}
