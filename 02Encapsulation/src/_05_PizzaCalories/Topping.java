package _05_PizzaCalories;

class Topping {
    private TopicModifiers modifier;
    private int weight;

    public Topping(String modifier, int weight) {
        setModifier(modifier);
        setWeight(weight, modifier);
    }

    public double calculateCalories() {

        double calories = 1;
        switch (this.getModifier()) {
            case CHEESE:
                calories *= 1.1;
                break;
            case MEAT:
                calories *= 1.2;
                break;
            case SAUCE:
                calories *= 0.9;
                break;
            case VEGGIES:
                calories *= 0.8;
                break;
        }
        return 2 * calories * this.getWeight();
    }

    private TopicModifiers getModifier() {
        return this.modifier;
    }

    private void setModifier(String modifier) {
        TopicModifiers tm = TopicModifiers.lookup(modifier);
        this.modifier = tm;
    }

    private int getWeight() {
        return this.weight;
    }

    private void setWeight(int weight, String name) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(name + " weight should be in the range [1..50].");
        } else this.weight = weight;
    }
}
