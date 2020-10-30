package hw04;

import hw04.linkedlist.MyLinkedList;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<Long> mll = new MyLinkedList<>();

        mll.addLast(2L);
        mll.addLast(3L);

        for (long x : mll) {
            System.out.print(x + " ");
        }
        System.out.println();

        System.out.println(mll.remove(4L));

    }
}
