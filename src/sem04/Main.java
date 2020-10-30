package sem04;

import java.io.Serializable;
import java.util.*;

public class Main {

    static class Item<T extends Comparable<T>> implements Comparable<Item<T>> {
        T data;

        Item(T data) {
            this.data = data;
        }

        @Override
        public int compareTo(Item<T> o) {
            return data.compareTo(o.data);
        }
    }

    static class MyNum<T> {
        T data;

        MyNum(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    static void print(Collection<?> coll) {
        for (var x : coll) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        MyNum<String> mn1 = new MyNum<>("123");
        MyNum<String> mn2 = new MyNum<>("456");

        System.out.println(mn1);
        System.out.println(mn2);

        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(3);
        ints.add(2);
        print(ints);
    }
}
