package _07_CarSalesman;

class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("  ").append(this.model).append(":\n");
        out.append("    Power: ").append(this.power).append("\n");
        out.append("    Displacement: ").append(this.displacement != 0 ? this.displacement : "n/a").append("\n");
        out.append("    Efficiency: ").append(this.efficiency != null ? this.efficiency : "n/a").append("\n");

        return out.toString();
    }

    public Engine(String model, int power, String efficiency) {
        this.model = model;
        this.power = power;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
    }

    public Engine(String model, int power, int displacement) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
    }

    public int getPower() {
        return this.power;
    }
}
