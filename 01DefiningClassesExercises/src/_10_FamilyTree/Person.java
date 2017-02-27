package _10_FamilyTree;

import java.util.ArrayList;
import java.util.List;


class Person {
    String name;
    String birthday;
    List<Person> parents;
    List<Person> children;

    Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(this.name).append(" ").append(this.birthday).append("\n");
        out.append("Parents:\n");
        for (Person parent : this.parents) {
            out.append(parent.name).append(" ").append(parent.birthday).append("\n");
        }
        out.append("Children:\n");
        for (Person child : this.children) {
            out.append(child.name).append(" ").append(child.birthday).append("\n");
        }
        return out.toString();
    }
}