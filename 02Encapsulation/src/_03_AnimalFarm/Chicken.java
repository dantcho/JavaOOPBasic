package _03_AnimalFarm;


class Chicken {

    private String name;
    private int age;
    private String productsPerDay;

    Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
        this.setProductsPerDay(age);
    }

    public void setName(String name) {
        if (name.trim().length() < 1) {
            throw new IllegalArgumentException("Name cannot be empty.");
        } else this.name = name;
    }


    private void setAge(int age) {
        if (age <= 0 || age >= 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        } else this.age = age;
    }


    private String getName() {
        return this.name;
    }

    private int getAge() {
        return this.age;
    }

    private String getProductsPerDay() {
        return this.productsPerDay;
    }

    private void setProductsPerDay(int age) {
        double eggsPerDay;
        if (age < 6) {
            this.productsPerDay = "2";
        } else if (age < 12) {
            this.productsPerDay = "1";
        } else {
            this.productsPerDay = "0.75";
        }
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %s eggs per day.",
                this.getName(), this.getAge(), this.getProductsPerDay());
    }
}
