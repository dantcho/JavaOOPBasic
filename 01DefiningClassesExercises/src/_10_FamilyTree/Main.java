package _10_FamilyTree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String person = reader.readLine();
        String regexDateDate = "(?<dateP>\\d+\\/\\d+\\/\\d+)\\s+-\\s+(?<dateC>\\d+\\/\\d+\\/\\d+)";
        String regexNameName = "(?<nameP>\\w+\\s+\\w+)\\s+-\\s+(?<nameC>\\w+\\s+\\w+)";
        String regexNameDate = "(?<name>\\w+\\s+\\w+)\\s+-\\s+(?<date>\\d+\\/\\d+\\/\\d+)";
        String regexDateName = "(?<date>\\d+\\/\\d+\\/\\d+)\\s+-\\s+(?<name>\\w+\\s+\\w+)";
        String regexNameBirthday = "(?<name>\\w+\\s+\\w+)\\s+(?<birthday>\\d+\\/\\d+\\/\\d+)";
        HashMap<String, Person> mapByDate = new HashMap<>();
        HashMap<String, Person> mapByName = new HashMap<>();
        String input = reader.readLine();
        List<String> relatedData = new ArrayList<>();
        List<String> data = new ArrayList<>();
        while (!input.equals("End")) {
            if (input.matches(regexNameBirthday)) {
                data.add(input);
            } else {
                relatedData.add(input);
            }
            input = reader.readLine();
        }
        Matcher matcher;
        data.forEach(s -> {
            Matcher m = Pattern.compile(regexNameBirthday).matcher(s);
            while (m.find()) {
                String name = m.group("name");
                String birthday = m.group("birthday");
                Person p = new Person(name, birthday);
                mapByDate.put(birthday, p);
                mapByName.put(name, p);
            }
        });

        Person printPerson = null;
        if (person.matches("(?<birthday>\\d+\\s*\\/\\s*\\d+\\s*\\/\\s*\\d+)")) {
            printPerson = mapByDate.get(person);
        } else if (person.matches("(?<name>\\w+\\s+\\w+)")) {
            printPerson = mapByName.get(person);
        }
        for (String line : relatedData) {
            if (line.matches(regexDateDate)) {
                matcher = Pattern.compile(regexDateDate).matcher(line);
                while (matcher.find()) {
                    String dateP = matcher.group("dateP");
                    String dateC = matcher.group("dateC");
                    Person children = mapByDate.get(dateC);
                    Person parent = mapByDate.get(dateP);
                    children.parents.add(parent);
                    parent.children.add(children);
                }
            } else if (line.matches(regexDateName)) {
                matcher = Pattern.compile(regexDateName).matcher(line);
                while (matcher.find()) {
                    String date = matcher.group("date");
                    String name = matcher.group("name");
                    Person parent = mapByDate.get(date);
                    Person children = mapByName.get(name);
                    parent.children.add(children);
                    children.parents.add(parent);
                }
            } else if (line.matches(regexNameDate)) {
                matcher = Pattern.compile(regexNameDate).matcher(line);
                while (matcher.find()) {
                    String name = matcher.group("name");
                    String date = matcher.group("date");
                    Person parent = mapByName.get(name);
                    Person children = mapByDate.get(date);
                    parent.children.add(children);
                    children.parents.add(parent);
                }
            } else if (line.matches(regexNameName)) {
                matcher = Pattern.compile(regexNameName).matcher(line);
                while (matcher.find()) {
                    String nameP = matcher.group("nameP");
                    String nameC = matcher.group("nameC");
                    Person parent = mapByName.get(nameP);
                    Person children = mapByName.get(nameC);
                    parent.children.add(children);
                    children.parents.add(parent);
                }
            }
        }
        System.out.print(printPerson);
    }
}

