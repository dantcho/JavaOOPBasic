package paw.models.centers;

public class AdoptionCenter extends Center {

    public AdoptionCenter(String name) {
        super(name);
    }

    public long countAnimalForAdopt() {
        return this.getAnimalsInCenter().stream().filter(animal -> animal.IsCleansed()).count();
    }
}
