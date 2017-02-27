package _09_Google;

class Children {
    private String name;
    private String birthday;

    Children(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }
    @Override
    public String toString() {
        return this.name + " " + this.birthday + "\n";
    }
}
