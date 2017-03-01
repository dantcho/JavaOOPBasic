package _05_PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Pizza pizza = null;
        while (!input.equals("END")) {
            String[] token = input.split("\\s+");
            String command = token[0];
            int weightOrCount = Integer.parseInt(token[token.length - 1]);
            switch (command) {
                case "Pizza":
                    try {
                        String name = token[1];
                        pizza = new Pizza(name, weightOrCount);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                        return;
                    }
                    break;
                case "Dough":
                    Dough dough = null;
                    try {
                        String flourType = token[1];
                        String bakingMethod = token[2];
                        dough = new Dough(weightOrCount, flourType, bakingMethod);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                        return;
                    }
                    if (pizza != null)
                        pizza.setDough(dough);
                    else System.out.printf("%.2f\n", dough.calculateCalories());
                    break;
                case "Topping":
                    Topping topping = null;
                    try {
                        String top = token[1];
                        topping = new Topping(top, weightOrCount);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                        return;
                    }
                    if (pizza != null)
                        pizza.addTopping(topping);
                    else System.out.printf("%.2f\n", topping.calculateCalories());
                    break;
            }
            input = reader.readLine();
        }//end while
        if (pizza != null) {
            System.out.printf("%s - %.2f\n", pizza.getName(), pizza.calculateCalories());
        }

    }
}
