package hw03.part1;

import java.util.Arrays;
import java.util.Optional;

public class Library {

    class Pair {
        int key;
        Book book;

        Pair(int key, Book book) {
            this.key = key;
            this.book = book;
        }
    }

    private Pair[] arr;
    private int capacity;
    private int size;

    public Library(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        arr = new Pair[capacity];
        size = 0;
    }
    public Library() {
        this(16);
    }

    private void rebuild() {
        Pair[] oldArr = new Pair[capacity];
        System.arraycopy(arr, 0, oldArr, 0, capacity);
        capacity *= 2;
        arr = new Pair[capacity];
        size = 0;
        for (Pair p : oldArr) {
            if (p != null) {
                addBook(p.book);
            }
        }
    }

    /**
     * stupid hash function
     * @param key
     * @return
     */
    private int hash(int key) {
        int h = key % capacity;
        if (h < 0)
            h += capacity;
        return h;
    }


    public boolean addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException();
        }
        int key = book.getName().hashCode();
        int i = hash(key);
        while (arr[i] != null && arr[i].key != key) {
            i = (i + 1) % capacity;
        }
        if (arr[i] == null) {
            arr[i] = new Pair(key, book);
            size++;
            if (size * 2 >= capacity) {
                rebuild();
            }
            return false;
        } else {
            return true;
        }
    }

    public Optional<Book> getBook(String name) {
        if (name == null || name.isEmpty()) {
            return Optional.empty();
        }
        int key = name.hashCode();
        int i = hash(key);
        while (arr[i] != null && arr[i].key != key) {
            i = (i + 1) % capacity;
        }
        if (arr[i] == null) {
            return Optional.empty();
        } else {
            return Optional.of(arr[i].book);
        }
    }

    public boolean findBook(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        return getBook(name).isPresent();
    }

    public int getSize() {
        return size;
    }
}
