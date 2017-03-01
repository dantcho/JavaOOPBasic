package _05_PizzaCalories;

import java.util.ArrayList;
import java.util.List;

class Dough {
    //private List<DoughModifiers> modifiers;

    private int weight;
    FlourType flourType;
    BakingTechnique bakingTechnique;

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        } else this.weight = weight;
    }

    public Dough(int weight, String flourType, String bakingMethod) {
        this.addFlour(flourType);
        this.addBakingMethod(bakingMethod);
        this.setWeight(weight);
    }


    public double calculateCalories() {
        double calories = 1;
        switch (this.flourType) {
            case WHITE:
                calories *= 1.5;
                break;
            case WHOLEGRAIN:
                calories *= 1;
                break;
        }
        switch (this.bakingTechnique) {
            case CRISPY:
                calories *= 0.9;
                break;
            case CHEWY:
                calories *= 1.1;
                break;
            case HOMEMADE:
                calories *= 1;
                break;
        }
        calories *= 2 * this.getWeight(); //Calories from dough weight
        return calories;
    }
    private void addBakingMethod(String bakingTechnique) {

        this.bakingTechnique = BakingTechnique.lookup(bakingTechnique);
    }

    private void addFlour(String flourType) {
        this.flourType = FlourType.lookup(flourType);
    }
}