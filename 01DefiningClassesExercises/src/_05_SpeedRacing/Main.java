package _05_SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(reader.readLine());
        LinkedHashMap<String,Car> carPark = new LinkedHashMap<>();
        for (int i = 0; i < num; i++) {
            String[]token = reader.readLine().split("\\s+");
            String model = token[0];
            double fuelAmount = Double.parseDouble(token[1]);
            double fuelCostPerKm = Double.parseDouble(token[2]);
            Car car = new Car(model,fuelAmount,fuelCostPerKm);
            carPark.put(model,car);
        }
        String input = reader.readLine();
        while (!input.equals("End")){
            String[]token = input.split("\\s+");
            String model = token[1];
            int distance = Integer.parseInt(token[2]);
            carPark.get(model).drive(distance);
            input=reader.readLine();
        }
        carPark.entrySet().stream().forEach(car-> System.out.println(car.getValue()));

    }
}
