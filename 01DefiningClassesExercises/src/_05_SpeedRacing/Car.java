package _05_SpeedRacing;

class Car {

    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private int distance;


    public Car(String model, double fuelAmount, double fuelCostPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distance = 0;
    }

    public void drive(int distance) {
        double fuelNeed = distance * this.fuelCostPerKm;
        if (fuelNeed > this.fuelAmount) {
            System.out.println("Insufficient fuel for the drive");
        } else {
            this.distance += distance;
            this.fuelAmount -= fuelNeed;
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(this.model).append(" ").append(String.format("%.2f", this.fuelAmount)).append(" ").append(this.distance);
        return out.toString();
    }


}
