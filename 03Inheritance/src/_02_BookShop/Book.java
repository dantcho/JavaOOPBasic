package _02_BookShop;

public class Book {

    private String title;
    private String author;
    private double price;


    private String getTitle() {
        return this.title;
    }

    private void setTitle(String title) throws IllegalArgumentException {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        } else this.title = title;
    }

    private String getAuthor() {
        return this.author;
    }

    private void setAuthor(String author) {
        String[] tokens = author.split("\\s+");

        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                throw new IllegalArgumentException("Author not valid!");
            }
        }

        this.author = author;
    }

    protected double getPrice() {
        return this.price;
    }

    private void setPrice(Double price) {
        if (price <= 0)
            throw new IllegalArgumentException("Price not valid!");
        else this.price = price;
    }

    public Book(String author, String title, Double price) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();
    }
}
