package hw04.linkedlist;

public class Node<E> {
    E e;
    Node<E> prev;
    Node<E> next;

    Node(E e) {
        this.e = e;
    }
}
