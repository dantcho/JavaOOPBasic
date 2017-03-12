package paw;

import paw.models.AnimalCenterManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        AnimalCenterManager animalCenterManager = new AnimalCenterManager();
        while (!input.equals("Paw Paw Pawah")) {
            String commandArgs[] = input.split("\\s+\\|\\s+");
            switch (commandArgs[0]) {
                case "RegisterAdoptionCenter":
                    animalCenterManager.registerAdoptionCenter(commandArgs[1]);
                    break;
                case "RegisterCleansingCenter":
                    animalCenterManager.registerCleansingCenter(commandArgs[1]);
                    break;
                case "RegisterDog":
                    animalCenterManager.registerDog(
                            commandArgs[1],
                            Integer.parseInt(commandArgs[2]),
                            Integer.parseInt(commandArgs[3]),
                            commandArgs[4]);
                    break;
                case "RegisterCat":
                    animalCenterManager.registerCat(
                            commandArgs[1],
                            Integer.parseInt(commandArgs[2]),
                            Integer.parseInt(commandArgs[3]),
                            commandArgs[4]);
                    break;
                case "SendForCleansing":
                    animalCenterManager.sendForCleansing(commandArgs[1],commandArgs[2]);
                    break;
                case "Cleanse":
                    animalCenterManager.cleanse(commandArgs[1]);
                    break;
                case "Adopt":
                    animalCenterManager.adopt(commandArgs[1]);
                    break;
                case "RegisterCastrationCenter":
                    animalCenterManager.registerCastrationCenter(commandArgs[1]);
                    break;
                case "SendForCastration":
                    animalCenterManager.sendForCastration(commandArgs[1],commandArgs[2]);
                    break;
                case "Castrate":
                    animalCenterManager.castrate(commandArgs[1]);
                    break;
                case "CastrationStatistics":
                    animalCenterManager.castrationStatistics();
                    break;
            }

            input = reader.readLine();
        }
        animalCenterManager.printStatistics();

    }
}
