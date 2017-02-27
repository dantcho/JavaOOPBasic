package _08_PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();
        while (!input.equals("Tournament")) {
            String[] token = input.split("\\s+");
            String trainerName = token[0];
            String pokName = token[1];
            String element = token[2];
            int health = Integer.parseInt(token[3]);
            if (!trainers.containsKey(trainerName)) {
                Trainer trainer = new Trainer(trainerName);
                trainers.put(trainerName, trainer);
            }
            Pokemon pokemon = new Pokemon(pokName, element, health);
            trainers.get(trainerName).addPokemon(pokemon);
            input = reader.readLine();
        }
        input = reader.readLine();
        while (!input.equals("End")) {
            final String element = input;
            trainers.forEach((s, trainer) -> {
                trainer.play(element);
            });
            input = reader.readLine();
        }
        trainers.entrySet().stream()
                .sorted((o1, o2) -> Integer.compare(o2.getValue().getNumberOfBadges(), o1.getValue().getNumberOfBadges()))
                .forEach(t -> System.out.println(t.getValue()));
    }
}
