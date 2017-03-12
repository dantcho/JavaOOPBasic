package paw.models.animals;

public abstract class Animal {
    private String name;
    private int age;
    private boolean isCleansed;
    private boolean isCastrated;
    private String adoptionCenter;

    public boolean isCastrated() {
        return this.isCastrated;
    }

    public void castrate() {
        this.isCastrated = true;
    }

    public boolean IsCleansed() {
        return this.isCleansed;
    }

    public void clean() {
        this.isCleansed = true;
    }

    public String getAdoptionCenter() {
        return this.adoptionCenter;
    }

    protected void setAdoptionCenter(String adoptionCenter) {
        this.adoptionCenter = adoptionCenter;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        if (age > 0)
            this.age = age;
    }

    protected Animal(String name, int age) {
        this.setName(name);
        this.setAge(age);
        this.isCleansed = false;
        this.isCastrated = false;
    }
}
