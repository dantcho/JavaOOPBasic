package _08_PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    @Override
    public String toString() {
        return this.name + " " + this.getNumberOfBadges() + " " + this.pokemons.size();
    }

    Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemons = new ArrayList<>();
    }

    int getNumberOfBadges() {
        return this.numberOfBadges;
    }

    void addPokemon(Pokemon p) {
        this.pokemons.add(p);
    }

    private void healthReduce() {
        this.pokemons.stream().forEach(pokemon -> pokemon.healthMinusTen());
    }

    private void addBadges() {
        this.numberOfBadges++;
    }

    private boolean checkForElement(String element) {
        boolean isFind = false;
        for (Pokemon pokemon : this.pokemons) {
            if (pokemon.getElement().equals(element)) {
                isFind = true;
                break;
            }
        }
        return isFind;
    }

    void play(String element) {
        if (checkForElement(element)) {
            addBadges();
        } else {
            healthReduce();
            pokemonReduce();
        }
    }

    private void pokemonReduce() {

        for (int i = 0; i < this.pokemons.size(); i++) {
            if (pokemons.get(i).getHealth() <= 0) {
                pokemons.remove(i);
                i--;
            }
        }
    }
}
