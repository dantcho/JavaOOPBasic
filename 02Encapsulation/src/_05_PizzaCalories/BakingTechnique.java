package _05_PizzaCalories;

enum BakingTechnique {
    CRISPY, CHEWY, HOMEMADE;

    public static BakingTechnique lookup(String id) {
        try {
            return BakingTechnique.valueOf(id.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }
}
