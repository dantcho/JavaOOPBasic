package _03_OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(reader.readLine());
        TreeSet<Person> persons = new TreeSet<>();
        for (int i = 0; i < num; i++) {
            String[] token = reader.readLine().split("\\s+");
            String name = token[0];
            int age = Integer.parseInt(token[1]);
            Person newP = new Person(name, age);
            persons.add(newP);
        }
        persons.stream().filter(x -> x.getAge() > 30).forEach(x -> System.out.println(x.getName() + " - " + x.getAge()));
    }
}
