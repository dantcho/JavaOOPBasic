package _06_RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(reader.readLine());
        LinkedHashSet<Car> cars = new LinkedHashSet<>();
        for (int i = 0; i < num; i++) {
            String[] token = reader.readLine().split("\\s+");
            String carModel = token[0];
            int engineSpeed = Integer.parseInt(token[1]);
            int enginePower = Integer.parseInt(token[2]);
            int cargoWeight = Integer.parseInt(token[3]);
            String cargoType = token[4];
            double tire1Pressure = Double.parseDouble(token[5]);
            int tire1Age = Integer.parseInt(token[6]);
            double tire2Pressure = Double.parseDouble(token[7]);
            int tire2Age = Integer.parseInt(token[8]);
            double tire3Pressure = Double.parseDouble(token[9]);
            int tire3Age = Integer.parseInt(token[10]);
            double tire4Pressure = Double.parseDouble(token[11]);
            int tire4Age = Integer.parseInt(token[12]);
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoType, cargoWeight);
            Tire t1 = new Tire(tire1Age, tire1Pressure);
            Tire t2 = new Tire(tire2Age, tire2Pressure);
            Tire t3 = new Tire(tire3Age, tire3Pressure);
            Tire t4 = new Tire(tire4Age, tire4Pressure);
            List<Tire> tires = new ArrayList<>();
            tires.add(t1);
            tires.add(t2);
            tires.add(t3);
            tires.add(t4);
            Car car = new Car(carModel, engine, cargo, tires);
            cars.add(car);
        }
        String command = reader.readLine();
        if (command.equals("fragile")) {
            cars.stream().filter(car -> {
                boolean fragile = car.cargo.getType().equals("fragile");
                Stream<Tire> tireStream = car.tires.stream().filter(tire -> tire.getPressure() < 1);
                boolean tStr = tireStream.count() > 0;
                return fragile && tStr;
            }).forEach(car -> System.out.println(car));

        } else if (command.equals("flamable")) {
            cars.stream().filter(car -> {
                boolean fragile = car.cargo.getType().equals("flamable");
                boolean engine = car.engine.getPower() > 250;
                return fragile && engine;
            }).forEach(car -> System.out.println(car));

        }
    }
}
