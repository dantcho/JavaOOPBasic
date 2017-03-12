package _04_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

 class Person {
    private String name;
    private double money;
    private List<Product> bag;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.bag = new ArrayList<>();
        this.money = money;
    }

    private List<Product> getBag() {
        return this.bag;
    }

    private void addToBag(Product product) {
        this.bag.add(product);
    }

    public String getName() {

        return this.name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else this.name = name;
    }

    private double getMoney() {
        return this.money;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        } else this.money = money;
    }

    public void buyProduct(Product product) {
        double price = product.getCost();
        if (getMoney() < price) {
            throw new IllegalArgumentException("");
        } else {
            this.addToBag(product);
            this.money -= price;
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(this.getName()).append(" - ");
        if (getBag().isEmpty()) {
            out.append("Nothing bought");
        } else {
            for (Product product : getBag()) {
                out.append(product).append(", ");
            }
            out.delete(out.length() - 2, out.length());
        }
        return out.toString();
    }
}
