package _09_Google;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        HashMap<String, People> peoples = new HashMap<>();
        while (!input.equals("End")) {
            String[] token = input.split("\\s+");
            String name = token[0];
            if (!peoples.containsKey(name)) {
                peoples.put(name, new People(name));
            }
            People tempPeople = peoples.get(name);
            String relation = token[1];
            switch (relation) {
                case "company":
                    String companyName = token[2];
                    String depatrmenet = token[3];
                    double salary = Double.parseDouble(token[4]);
                    tempPeople.changeCompany(new Company(companyName, depatrmenet, salary));
                    break;
                case "pokemon":
                    String pokemonName = token[2];
                    String pokemonType = token[3];
                    tempPeople.addPokemon(new Pokemon(pokemonName, pokemonType));
                    break;
                case "parents":
                    String parentName = token[2];
                    String parentBirthday = token[3];
                    tempPeople.addParent(new Parent(parentName, parentBirthday));
                    break;
                case "children":
                    String childName = token[2];
                    String childBirthday = token[3];
                    tempPeople.addChildren(new Children(childName, childBirthday));
                    break;
                case "car":
                    String carModel = token[2];
                    int carSpeed = Integer.parseInt(token[3]);
                    tempPeople.changeCar(new Car(carModel, carSpeed));
                    break;
            }
            peoples.put(name, tempPeople);
            input = reader.readLine();
        }

        String nameToList = reader.readLine();
        System.out.println(peoples.get(nameToList));
    }
}
