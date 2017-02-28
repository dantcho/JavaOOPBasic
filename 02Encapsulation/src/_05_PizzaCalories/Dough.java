package _05_PizzaCalories;

import java.util.ArrayList;
import java.util.List;

class Dough {
    private List<DoughModifiers> modifiers;
    private int weight;

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        } else this.weight = weight;
    }

    public Dough(int weight, String... modifiers) {
        this.modifiers = new ArrayList<>();
        this.setWeight(weight);
        this.addModifiers(modifiers);
    }

    public double calculateCalories() {
        double calories = 1;
        for (DoughModifiers modifier : getModifiers()) {
            switch (modifier) {
                case WHITE:
                    calories *= 1.5;
                    break;
                case WHOLEGRAIN:
                    calories *= 1;
                    break;
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
        }
        calories *= 2 * this.getWeight(); //Calories from dough weight
        return calories;
    }


    private List<DoughModifiers> getModifiers() {
        return this.modifiers;
    }

    private void addModifier(DoughModifiers modifier) {
        this.modifiers.add(modifier);
    }
    private void addModifiers(String[] modifiers) {
        for (String modifier : modifiers) {
            DoughModifiers m = DoughModifiers.lookup(modifier);
            this.addModifier(m);
        }
    }
}