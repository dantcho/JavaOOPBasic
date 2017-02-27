package _09_Google;

import java.util.ArrayList;
import java.util.List;

 class People {
    private String name;
    private Car car;
    private Company company;
    private List<Parent> parents;
    private List<Pokemon> pokemons;
    private List<Children> children;

    public People(String name) {
        this.name = name;
        this.parents = new ArrayList<>();
        this.pokemons = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void addParent(Parent p) {
        this.parents.add(p);
    }

    public void addChildren(Children c) {
        this.children.add(c);
    }

    public void addPokemon(Pokemon p) {
        this.pokemons.add(p);
    }

    public void changeCar(Car car) {
        this.car = car;
    }

    public void changeCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {

        StringBuilder out = new StringBuilder();
        out
                .append(this.name).append("\n")
                .append("Company:").append("\n");
        if (this.company != null) {
            out.append(this.company);
        }
        out.append("Car:").append("\n");
        if (this.car != null) {
            out.append(this.car);
        }
        out.append("Pokemon:").append("\n");
        for (Pokemon pokemon : this.pokemons) {
            out.append(pokemon);
        }
        out.append("Parents:").append("\n");
        for (Parent parent :this.parents) {
            out.append(parent);
        }
        out.append("Children:").append("\n");
        for (Children children : this.children) {
            out.append(children);
        }
        return out.toString();
    }
}
