package _01_Person;

public class Person {
    private String name;
    private int age;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {

        if (name.length()<3) {
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        } else this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException("Age must be positive!");
        } else this.age = age;
    }

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s, Age: %d",
                this.getName(),
                this.getAge()));

        return sb.toString();
    }
}
