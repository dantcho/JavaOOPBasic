package _02_CreatingConstructors;

class Person {
    public String name;
    public int age;

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

}
