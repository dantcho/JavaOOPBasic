package _08_PokemonTrainer;

class Pokemon {
    private String name;
    private String element;
    private int health;

    String getElement() {
        return this.element;
    }

    Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    void healthMinusTen() {
        this.health -= 10;
    }

    int getHealth() {
        return this.health;
    }
}
