package _07_CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(reader.readLine());
        LinkedHashMap<String, Engine> engines = new LinkedHashMap<>();
        LinkedHashSet<Car> cars = new LinkedHashSet<>();
        for (int i = 0; i < num; i++) {
            String[] token = reader.readLine().split("\\s+");
            String model = token[0];
            int power = Integer.parseInt(token[1]);
            Engine engine = null;
            if (token.length == 3) {
                try {
                    int displacement = Integer.parseInt(token[2]);
                    engine = new Engine(model, power, displacement);

                } catch (NumberFormatException ex) {
                    String efficiency = token[2];
                    engine = new Engine(model, power, efficiency);
                }
            } else if (token.length == 2) {
                engine = new Engine(model, power);
            } else {
                int displacement = Integer.parseInt(token[2]);
                String efficiency = token[3];
                engine = new Engine(model, power, displacement, efficiency);
            }
            engines.put(model, engine);
        }
        num = Integer.valueOf(reader.readLine());
        for (int i = 0; i < num; i++) {
            String[] token = reader.readLine().split("\\s+");
            String model = token[0];
            String engineModel = token[1];
            Engine engine = engines.get(engineModel);
            Car car = null;
            if (token.length == 3) {
                try {
                    int weight = Integer.parseInt(token[2]);
                    car = new Car(model, engine, weight);

                } catch (NumberFormatException ex) {
                    String color = token[2];
                    car = new Car(model, engine, color);
                }
            } else if (token.length == 2) {
                car = new Car(model, engine);
            } else {
                int weight = Integer.parseInt(token[2]);
                String color = token[3];
                car = new Car(model, engine, weight, color);
            }
            cars.add(car);
        }
        cars.stream().forEach(car -> System.out.print(car));
    }
}
