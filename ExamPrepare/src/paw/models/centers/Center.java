package paw.models.centers;

import paw.models.animals.Animal;

import java.util.ArrayList;
import java.util.List;

public abstract class Center {
    private String name;
    private List<Animal> animalsInCenter;

    public void addAnimalToCenter(Animal animal){
        this.animalsInCenter.add(animal);
    }

    public List<Animal> getAnimalsInCenter() {
        return this.animalsInCenter;
    }

    protected Center(String name) {
        this.name = name;
        this.animalsInCenter = new ArrayList<>();
    }
}
