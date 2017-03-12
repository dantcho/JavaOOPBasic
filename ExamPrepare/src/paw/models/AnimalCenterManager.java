package paw.models;

import paw.models.animals.Animal;
import paw.models.animals.Cat;
import paw.models.animals.Dog;
import paw.models.centers.AdoptionCenter;
import paw.models.centers.CastrationCenter;
import paw.models.centers.CleansingCenter;

import java.util.*;
import java.util.stream.Collectors;

public class AnimalCenterManager {

    private HashMap<String, AdoptionCenter> adoptionCenters;
    private HashMap<String, CleansingCenter> cleansingCenters;
    private HashMap<String, CastrationCenter> castratingCenters;
    private TreeMap<String, Animal> cleansedAnimals;
    private TreeMap<String, Animal> adoptedAnimals;
    private TreeMap<String, Animal> castratedAnimals;

    public AnimalCenterManager() {
        this.adoptionCenters = new HashMap<>();
        this.cleansingCenters = new HashMap<>();
        this.castratingCenters = new HashMap<>();
        this.cleansedAnimals = new TreeMap<>();
        this.adoptedAnimals = new TreeMap<>();
        this.castratedAnimals = new TreeMap<>();
    }

    public void registerCleansingCenter(String name) {
        CleansingCenter cleansingCenter = new CleansingCenter(name);
        this.cleansingCenters.putIfAbsent(name, cleansingCenter);
    }

    public void registerAdoptionCenter(String name) {
        AdoptionCenter adoptionCenter = new AdoptionCenter(name);
        adoptionCenters.putIfAbsent(name, adoptionCenter);
    }

    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        Dog dog = new Dog(name, age, learnedCommands, adoptionCenterName);
        this.adoptionCenters.get(adoptionCenterName).addAnimalToCenter(dog);
    }

    public void registerCat(String name, int age, int intelligenceCoefficient, String adoptionCenterName) {
        Cat cat = new Cat(name, age, intelligenceCoefficient, adoptionCenterName);
        this.adoptionCenters.get(adoptionCenterName).addAnimalToCenter(cat);
    }

    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        AdoptionCenter adoptionCenter = this.adoptionCenters.get(adoptionCenterName);
        CleansingCenter cleansingCenter = this.cleansingCenters.get(cleansingCenterName);
        List<Animal> animals = adoptionCenter.getAnimalsInCenter().stream().filter(animal -> !animal.IsCleansed()).collect(Collectors.toList());
        animals.forEach(animal -> {
                    cleansingCenter.addAnimalToCenter(animal);
                    adoptionCenter.getAnimalsInCenter().remove(animal);
                }
        );
    }

    public void cleanse(String cleansingCenterName) {
        CleansingCenter cleansingCenter = this.cleansingCenters.get(cleansingCenterName);
        cleansingCenter.getAnimalsInCenter().forEach(animal -> {
            animal.clean();
            this.cleansedAnimals.put(animal.getName(), animal);
            this.adoptionCenters.get(animal.getAdoptionCenter()).addAnimalToCenter(animal);
        });
        cleansingCenter.getAnimalsInCenter().clear();
    }

    public void adopt(String adoptionCenterName) {
        AdoptionCenter adoptionCenter = this.adoptionCenters.get(adoptionCenterName);
        List<Animal> animals = adoptionCenter.getAnimalsInCenter().stream().filter(animal -> animal.IsCleansed()).collect(Collectors.toList());
        animals.forEach(animal -> {
            adoptionCenter.getAnimalsInCenter().remove(animal);
            this.adoptedAnimals.put(animal.getName(), animal);
        });

    }

    public void printStatistics() {
        StringBuilder out = new StringBuilder();
        Optional<Long> waitForAdopt = this.adoptionCenters.entrySet().stream().map(x -> x.getValue().countAnimalForAdopt()).reduce((x, y) -> x + y);
        Optional<Integer> waitForCleanse = this.cleansingCenters.entrySet().stream().map(x -> x.getValue().getAnimalsInCenter().size()).reduce((x, y) -> x + y);

        List<String> adoptedAnimals = this.adoptedAnimals.entrySet().stream().map(animal -> animal.getKey()).collect(Collectors.toList());
        List<String> cleansedAnimals = this.cleansedAnimals.entrySet().stream().map(animal -> animal.getKey()).collect(Collectors.toList());
        out.append("Paw Incorporative Regular Statistics\n")
                .append("Adoption Centers: ").append(this.adoptionCenters.size()).append("\n")
                .append("Cleansing Centers: ").append(this.cleansingCenters.size()).append("\n")
                .append("Adopted Animals: ").append(adoptedAnimals.size() > 0 ? String.join(", ", adoptedAnimals) : "None").append("\n")
                .append("Cleansed Animals: ").append(cleansedAnimals.size() > 0 ? String.join(", ", cleansedAnimals) : "None").append("\n")
                .append("Animals Awaiting Adoption: ").append(waitForAdopt.isPresent() ? waitForAdopt.get() : "None").append("\n")
                .append("Animals Awaiting Cleansing: ").append(waitForCleanse.isPresent() ? waitForCleanse.get() : "None").append("\n");
        System.out.println(out);
    }

    public void registerCastrationCenter(String name) {
        CastrationCenter castrationCenter = new CastrationCenter(name);
        this.castratingCenters.put(name, castrationCenter);

    }

    public void sendForCastration(String adoptCenter, String castCenter) {
        AdoptionCenter adoptionCenter = this.adoptionCenters.get(adoptCenter);
        CastrationCenter castrationCenter = this.castratingCenters.get(castCenter);
        List<Animal> animals = adoptionCenter.getAnimalsInCenter().stream().filter(animal -> !animal.isCastrated()).collect(Collectors.toList());
        animals.forEach(animal -> {
            adoptionCenter.getAnimalsInCenter().remove(animal);
            castrationCenter.addAnimalToCenter(animal);
        });

    }

    public void castrate(String castCenter) {
        CastrationCenter castrationCenter = this.castratingCenters.get(castCenter);
        castrationCenter.getAnimalsInCenter().forEach(animal -> {
            animal.castrate();
            this.adoptionCenters.get(animal.getAdoptionCenter()).addAnimalToCenter(animal);
            this.castratedAnimals.put(animal.getName(), animal);
        });
        castrationCenter.getAnimalsInCenter().clear();

    }

    public void castrationStatistics() {
        List<String> castratedAnimals = this.castratedAnimals.entrySet().stream().map(x -> x.getKey()).collect(Collectors.toList());

        StringBuilder out = new StringBuilder();
        out
                .append("Paw Inc. Regular Castration Statistics\n")
                .append("Castration Centers: ").append(this.castratingCenters.size()).append("\n")
                .append("Castrated Animals: ").append(castratedAnimals.size() > 0 ? String.join(", ", castratedAnimals) : "None");
        System.out.println(out);
    }
}
