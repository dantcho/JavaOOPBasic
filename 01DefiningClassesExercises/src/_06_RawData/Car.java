package _06_RawData;

import java.util.List;

class Car {
    String model;
    Engine engine;
    Cargo cargo;
    List<Tire> tires;

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    @Override
    public String toString() {
        return this.model;
    }
    public void addTire(Tire t){
        this.tires.add(t);
    }
}
