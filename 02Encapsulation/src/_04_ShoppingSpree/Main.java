package _04_ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        LinkedHashMap<String, Person> persons = new LinkedHashMap<>();
        HashMap<String, Product> products = new HashMap<>();
        String[] token = input.split(";"); //Split Users
        try {
            for (String personPair : token) {
                String[] pp = personPair.split("=");
                String name = pp[0];
                Person person = new Person(name, Double.parseDouble(pp[1]));
                persons.put(name, person);
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }
        input = reader.readLine();
        token = input.split(";"); //Split Products
        try {
            for (String productPair : token) {
                String[] pp = productPair.split("=");
                String name = pp[0];
                Product product = new Product(name, Double.parseDouble(pp[1]));
                products.put(name, product);
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }
        input = reader.readLine();
        while (!input.equals("END")) {
            token = input.split("\\s+");
            String personName = token[0];
            String productName = token[1];
            Person person = persons.get(personName);
            Product product = products.get(productName);
            try {
                person.buyProduct(product);
                System.out.println(person.getName() + " bought " + product.getName());
            } catch (IllegalArgumentException ex) {
                System.out.println(person.getName() + " can't afford " + product.getName());
            }
            input = reader.readLine();
        }
        for (Person person : persons.values()) {
            System.out.println(person);
        }

    }
}
