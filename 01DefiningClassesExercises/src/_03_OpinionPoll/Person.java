package _03_OpinionPoll;

class Person implements Comparable {
    private String name;
    private int age;

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(int age) {
        this("No name", age);
    }

    public Person() {
        this(1);
    }

    @Override
    public int compareTo(Object o) {
        return (this.name.compareTo(((Person) o).name));
    }
}
