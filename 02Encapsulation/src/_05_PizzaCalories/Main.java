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

            int modLen = token.length - 2;
            String[] modifiers = new String[modLen];
            for (int i = 0; i < modLen; i++) {
                modifiers[i] = token[i + 1];
            }
            int weightOrCount = Integer.parseInt(token[token.length - 1]);
            switch (command) {
                case "Pizza":
                    try {
                        pizza = new Pizza(modifiers[0], weightOrCount);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                        return;
                    }
                    break;
                case "Dough":
                    Dough dough = null;
                    try {
                        dough = new Dough(weightOrCount, modifiers);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                        return;
                    }
                    pizza.setDough(dough);
                    break;
                case "Topping":
                    Topping topping = null;
                    try {
                        topping = new Topping(modifiers[0], weightOrCount);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                        return;
                    }
                    pizza.addTopping(topping);
                    break;
            }
            input = reader.readLine();
        }//end while
        System.out.println(pizza.getName()+" - "+pizza.calculateCalories());

    }
}
