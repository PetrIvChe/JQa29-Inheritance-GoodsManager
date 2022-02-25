package ru.netology.domain;

import java.util.Objects;

public class Book extends Product {
    private String author;
    private String nameOfBook;

    public Book() {
        super();
    }

    public Book(int id, String name, int price, String author, String nameOfBook) {
        super(id, name, price);
        this.author = author;
        this.nameOfBook = nameOfBook;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public String setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
        return nameOfBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author) &&
               Objects.equals(nameOfBook, book.nameOfBook);


    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author, nameOfBook);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", nameOfBook=" + nameOfBook +
                '}';
    }
}