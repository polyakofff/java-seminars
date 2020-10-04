package hw03.part1;

import java.util.Objects;

public class Book {
    private String name;
    private int nPages;

    public Book(String name, int nPages) {
        if (name == null || name.isEmpty() || nPages <= 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.nPages = nPages;
    }

    public String getName() {
        return name;
    }

    public int getnPages() {
        return nPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", nPages=" + nPages +
                '}';
    }
}
