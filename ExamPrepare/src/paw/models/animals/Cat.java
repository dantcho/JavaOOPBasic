package paw.models.animals;

public class Cat extends Animal {
    private int iq;

    public void setIq(int iq) {
        if (iq > 0)
            this.iq = iq;
    }

    public Cat(String name, int age, int iq, String aCenter) {
        super(name, age);
        this.setAdoptionCenter(aCenter);
        this.setIq(iq);
    }
}
