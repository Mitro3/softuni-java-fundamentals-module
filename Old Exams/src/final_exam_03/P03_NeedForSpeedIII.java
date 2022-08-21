package final_exam_03;

import java.util.*;

public class P03_NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carsCount = Integer.parseInt(scanner.nextLine());

        Map<String, List<Integer>> carsMap = new LinkedHashMap<>();
        for (int i = 0; i < carsCount; i++) {
            String[] currCarInfo = scanner.nextLine().split("\\|");
            String currCarName = currCarInfo[0];
            int currCarMileage = Integer.parseInt(currCarInfo[1]);
            int currCarFuel = Integer.parseInt(currCarInfo[2]);

            List<Integer> currCarData = new ArrayList<>();
            currCarData.add(currCarMileage);
            currCarData.add(currCarFuel);

            carsMap.putIfAbsent(currCarName, currCarData);
        }

        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] commandLine = command.split(" : ");
            String currCommand = commandLine[0];
            String currCar = commandLine[1];

            switch (currCommand) {
                case "Drive":
                    int distanceToTravel = Integer.parseInt(commandLine[2]);
                    int fuelNeeded = Integer.parseInt(commandLine[3]);

                    int currCarMileage = carsMap.get(currCar).get(0);
                    int currCarFuel = carsMap.get(currCar).get(1);

                    if (currCarFuel >= fuelNeeded) {
                        currCarMileage += distanceToTravel;
                        currCarFuel -= fuelNeeded;
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", currCar, distanceToTravel, fuelNeeded);

                        if (currCarMileage >= 100000) {
                            carsMap.remove(currCar);
                            System.out.println("Time to sell the " + currCar + "!");
                        } else {
                            List<Integer> updatedCarData = new ArrayList<>();
                            updatedCarData.add(currCarMileage);
                            updatedCarData.add(currCarFuel);
                            carsMap.put(currCar,updatedCarData);
                        }
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    break;

                case "Refuel":
                    int fuelToRefill = Integer.parseInt(commandLine[2]); //15
                    currCarFuel = carsMap.get(currCar).get(1); //65
                    int refueledLiters = 0;

                    int totalFuel = fuelToRefill + currCarFuel; //80
                    if (totalFuel > 75) {
                        refueledLiters = 75 - currCarFuel; //10
                        currCarFuel = 75;

                    } else {
                        refueledLiters = fuelToRefill;
                        currCarFuel += refueledLiters;
                    }

                    carsMap.get(currCar).set(1, currCarFuel);
                    System.out.printf("%s refueled with %d liters%n", currCar, refueledLiters);
                    break;

                case "Revert":
                    int kilometersToDecrease = Integer.parseInt(commandLine[2]); //20 000
                    currCarMileage = carsMap.get(currCar).get(0); //10 000
                    int revertedKilometers = currCarMileage - kilometersToDecrease; //-10 000

                    if (revertedKilometers < 10000) {
                        revertedKilometers = 10000;
                        carsMap.get(currCar).set(0, revertedKilometers);
                    } else {
                        currCarMileage -= kilometersToDecrease;
                        carsMap.get(currCar).set(0, currCarMileage);
                        System.out.printf("%s mileage decreased by %d kilometers%n", currCar, kilometersToDecrease);
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        carsMap.entrySet().forEach(car -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n"
                ,car.getKey(), car.getValue().get(0), car.getValue().get(1)));
    }
}

