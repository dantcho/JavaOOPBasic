package _05_PizzaCalories;

enum TopicModifiers {
    MEAT, VEGGIES, CHEESE, SAUCE;

    public static TopicModifiers lookup(String id) {
        try {
            return TopicModifiers.valueOf(id.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Cannot place " + id + " on top of your pizza.");
        }
    }
}
