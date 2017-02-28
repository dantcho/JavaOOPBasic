package _05_PizzaCalories;

import java.util.ArrayList;
import java.util.List;

class Pizza {

    private String name;
    private List<Topping> toppings;
    private Dough dough;
    private int numOfToppings;

    private List<Topping> getToppings() {
        return this.toppings;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    private Dough getDough() {
        return this.dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return this.name;
    }

    private int getNumOfToppings() {
        return this.numOfToppings;
    }

    private void setNumOfToppings(int numOfToppings) {
        if (numOfToppings < 1 || numOfToppings > 15) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numOfToppings = numOfToppings;
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }


    public Pizza(String name, int numOfToppings) {
        setName(name);
        setNumOfToppings(numOfToppings);
        this.toppings = new ArrayList<>();
    }

    public double calculateCalories() {
        double calories = 0;
        for (Topping topping : getToppings()) {
            calories += topping.calculateCalories();
        }
        calories += this.getDough().calculateCalories();
        return calories;
    }
}
