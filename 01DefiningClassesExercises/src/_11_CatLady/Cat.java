package _11_CatLady;

public class Cat {
    String name;
    String breed;
    String attribute;

    public Cat(String name, String breed, String attribute) {
        this.name = name;
        this.breed = breed;
        this.attribute = attribute;
    }

    @Override
    public String toString() {
        return this.breed + " " + this.name + " " + this.attribute;
    }
}
