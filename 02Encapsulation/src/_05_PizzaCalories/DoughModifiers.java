package _05_PizzaCalories;

enum DoughModifiers {
    WHITE, WHOLEGRAIN, CRISPY, CHEWY, HOMEMADE;

    public static DoughModifiers lookup(String id) {
        try {
            return DoughModifiers.valueOf(id.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }
}
