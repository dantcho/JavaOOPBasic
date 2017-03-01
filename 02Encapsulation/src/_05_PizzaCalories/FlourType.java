package _05_PizzaCalories;

enum FlourType {
    WHITE, WHOLEGRAIN;

    public static FlourType lookup(String id) {
        try {
            return FlourType.valueOf(id.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }
}
