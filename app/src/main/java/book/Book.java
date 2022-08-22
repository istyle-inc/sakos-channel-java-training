package book;

import java.security.PublicKey;

import interfaces.BookInterface;

public class Book implements BookInterface {
    private final String title;
    private final String author;
    private int price = 0;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;

    }

    @Override
    public String author() {
        return author;
    }

    @Override
    public String title() {
        return title;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void getPrice(int price){
        return price;
    }
}