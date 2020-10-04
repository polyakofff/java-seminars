package hw03;

import hw03.part1.*;

import java.util.HashMap;
import java.util.Optional;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Library lib = new Library(3);

//        HashMap<String, Book> hm = new HashMap<>();

        long t0 = System.currentTimeMillis();

        Random rand = new Random();

        for (int i = 0; i < 4_000_000; i++) {
            StringBuilder name = new StringBuilder();
            for (int j = 0; j < 10; j++) {
                name.append(rand.nextInt(128));
            }

            lib.addBook(new Book(name.toString(), rand.nextInt(1_000_000_000)));
        }

        long t = System.currentTimeMillis();
        System.out.println(t - t0);

        // работает быстрее чем HashMap !

    }
}
