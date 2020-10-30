package hw04.linkedlist;

public interface MyList<E> {

    void add(E e);
    void addFirst(E e);
    void addLast(E e);
    void add(int i, E e);

    boolean remove(E e);
    E removeFirst();
    E removeLast();
    E remove(int i);

    E getFirst();
    E getLast();
    E get(int i);

    int size();
}
