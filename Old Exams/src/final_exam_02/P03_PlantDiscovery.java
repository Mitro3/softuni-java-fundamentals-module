package final_exam_02;

import java.util.*;

public class P03_PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> plantsMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] inputData = input.split("<->");
            String currPlantName = inputData[0];
            double currPlantRarity = Integer.parseInt(inputData[1]);

            List<Double> currPlantInfo = new ArrayList<>();
            currPlantInfo.add(0, currPlantRarity);
            currPlantInfo.add(1, 0.0);
            plantsMap.put(currPlantName, currPlantInfo);
        }

        String commandLine = scanner.nextLine();
        while (!commandLine.equals("Exhibition")) {
            String command = commandLine.split(": ")[0];
            String plantName = commandLine.split("[:]\\s|[\\s][-][\\s]")[1];
            if (isValidPlantName(plantName, plantsMap)) {
                double currPlantRarity = plantsMap.get(plantName).get(0);
                double currPlantRating = plantsMap.get(plantName).get(1);
                List<Double> updatedPlantInfo = new ArrayList<>();

                switch (command) {
                    case "Rate":
                        double newPlantRating = Double.parseDouble(commandLine.split("[:]\\s|[\\s][-][\\s]")[2]);
                        currPlantRarity = plantsMap.get(plantName).get(0);
                        currPlantRating = plantsMap.get(plantName).get(1);

                        if (currPlantRating != 0) {
                            currPlantRating = (newPlantRating + currPlantRating) / 2;
                        } else {
                            currPlantRating = newPlantRating;
                        }

                        updadePlantInfo(updatedPlantInfo, currPlantRarity, currPlantRating, plantName, plantsMap);
                        break;

                    case "Update":
                        double newPlantRarity = Double.parseDouble(commandLine.split("[:]\\s|[\\s][-][\\s]")[2]);
                        currPlantRarity = newPlantRarity;
                        currPlantRating = plantsMap.get(plantName).get(1);

                        updadePlantInfo(updatedPlantInfo, currPlantRarity, currPlantRating, plantName, plantsMap);

                        break;

                    case "Reset":
                        currPlantRarity = plantsMap.get(plantName).get(0);
                        currPlantRating = 0.0;

                        updadePlantInfo(updatedPlantInfo, currPlantRarity, currPlantRating, plantName, plantsMap);
                        break;
                }

            } else {
                System.out.println("error");
            }

            commandLine = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        plantsMap.entrySet().forEach(plant -> System.out.printf("- %s; Rarity: %.0f; Rating: %.2f%n",
                plant.getKey(), plant.getValue().get(0), plant.getValue().get(1)));
    }

    private static void updadePlantInfo(List<Double> updatedPlantInfo, double currPlantRarity, double currPlantRating,
                                        String plantName, Map<String, List<Double>> plantsMap) {
        updatedPlantInfo.add(currPlantRarity);
        updatedPlantInfo.add(currPlantRating);
        plantsMap.put(plantName, updatedPlantInfo);
    }

    private static boolean isValidPlantName(String plantName, Map<String, List<Double>> plantsMap) {
        return plantsMap.containsKey(plantName);
    }
}
