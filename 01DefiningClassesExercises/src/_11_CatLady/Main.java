package _11_CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Cat> cats = new HashMap<>();
        String input = reader.readLine();
        while (!input.equals("End")) {
            String[] token = input.split("\\s+");
            String name= token[1];
            String breed= token[0];
            String attribute= token[2];
            cats.put(name,new Cat(name,breed,attribute));
            input = reader.readLine();
        }
        String cat = reader.readLine();
        System.out.println(cats.get(cat));
    }
}

