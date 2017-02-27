package _07_CarSalesman;

import java.awt.*;

class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this.model = model;
        this.engine = engine;
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(this.model).append(":\n");
        out.append(this.engine);
        out.append("  Weight: ").append(this.weight != 0 ? this.weight : "n/a").append("\n");
        out.append("  Color: ").append(this.color != null ? this.color : "n/a").append("\n");
        return out.toString();
    }
}
