package final_exam_05;

import java.util.*;

public class P03_Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Integer>> citiesMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Sail")) {
            String[] inputArray = input.split("\\|\\|");
            String cityName = inputArray[0];
            int newCityPopulation = Integer.parseInt(inputArray[1]);
            int newCityGold = Integer.parseInt(inputArray[2]);

            List<Integer> currCityInfo = new ArrayList<>();

            if (!citiesMap.containsKey(cityName)) {
                currCityInfo.add(newCityPopulation);
                currCityInfo.add(newCityGold);
                citiesMap.put(cityName, currCityInfo);

            } else {
                int currCityPopulation = citiesMap.get(cityName).get(0);
                int currCityGold = citiesMap.get(cityName).get(1);
                currCityPopulation += newCityPopulation;
                currCityGold += newCityGold;
                currCityInfo.add(0, currCityPopulation);
                currCityInfo.add(1, currCityGold);
                citiesMap.put(cityName, currCityInfo);
            }

            input = scanner.nextLine();
        }

        String commandLine = scanner.nextLine();
        while (!commandLine.equals("End")) {
            String[] commandLineData = commandLine.split("=>");
            String command = commandLineData[0];
            String town = commandLineData[1];
            List<Integer> currCityInfo = new ArrayList<>();

            switch (command) {
                case "Plunder":
                    int populationToPlunder = Integer.parseInt(commandLineData[2]);
                    int goldToPlunder = Integer.parseInt(commandLineData[3]);
                    int updatedPopulation = citiesMap.get(town).get(0) - populationToPlunder;
                    int updatedGold = citiesMap.get(town).get(1) - goldToPlunder;

                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n",
                            town, goldToPlunder, populationToPlunder);

                    if (updatedPopulation <= 0 || updatedGold <= 0) {
                        System.out.printf("%s has been wiped off the map!%n", town);
                        citiesMap.remove(town);
                    } else {
                        currCityInfo.add(0, updatedPopulation);
                        currCityInfo.add(1, updatedGold);
                        citiesMap.put(town, currCityInfo);
                    }

                    break;

                case "Prosper":
                    int goldToProsper = Integer.parseInt(commandLineData[2]);

                    if (goldToProsper < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        int currCityPopulation = citiesMap.get(town).get(0);
                        int updatedGoldGrowth = citiesMap.get(town).get(1) + goldToProsper;
                        currCityInfo.add(0, currCityPopulation);
                        currCityInfo.add(1, updatedGoldGrowth);
                        citiesMap.put(town, currCityInfo);

                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",
                                goldToProsper, town, updatedGoldGrowth);
                    }

                    break;
            }

            commandLine = scanner.nextLine();
        }

        if (citiesMap.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n",
                    citiesMap.size());
            citiesMap.entrySet().forEach(city -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                    city.getKey(), city.getValue().get(0), city.getValue().get(1)));
        }
    }
}
