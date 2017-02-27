package _09_Google;

class Car {
    private String model;
    private int speed;

    Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return this.model + " " + this.speed + "\n";
    }
}
