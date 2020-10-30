package hw04.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList<E>, Iterable<E> {
    Node<E> head;
    Node<E> tail;
    int size = 0;


    /**
     * пустой конструктор
     */
    public MyLinkedList() {
    }


    /**
     * добавить узел node так, чтобы узел prev был слева, а узел next справа
     * @param prev узел слева
     * @param node добавляемый узел
     * @param next узел справа
     */
    private void link(Node<E> prev, Node<E> node, Node<E> next) {
        if (prev == null) {
            head = node;
        } else {
            prev.next = node;
        }
        if (next == null) {
            tail = node;
        } else {
            next.prev = node;
        }
        node.prev = prev;
        node.next = next;
        size++;
    }


    /**
     * удалить узел node
     * @param node удаляемый узел
     */
    private void unlink(Node<E> node) {
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
        }
        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
        }
        node.prev = null;
        node.next = null;
        size--;
    }


    /**
     * добавить элемент e в конец списка
     * @param e добавляемый элемент
     */
    @Override
    public void add(E e) {
        addLast(e);
    }


    /**
     * добавить элемент e в начало списка
     * @param e добавляемый элемент
     */
    @Override
    public void addFirst(E e) {
        link(null, new Node<>(e), head);
    }


    /**
     * добавить элемент e в конец списка
     * @param e добавляемый элемент
     */
    @Override
    public void addLast(E e) {
        link(tail, new Node<>(e), null);
    }


    /**
     * добавить элемент e на позицию i
     * @param i позиция
     * @param e добавляемый элемент
     */
    @Override
    public void add(int i, E e) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();
        }
        if (i == 0) {
            addFirst(e);
        } else if (i == size) {
            addLast(e);
        } else {
            Node<E> prev = nodeAt(i - 1);
            Node<E> next = prev.next;
            link(prev, new Node<>(e), next);
        }
    }


    /**
     * удалить первое вхождение элемента e
     * @param e удаляемый элемент
     * @return true - если удаление произлошло, false - иначе
     */
    @Override
    public boolean remove(E e) {
        Node<E> oldn = head;
        while (oldn != null) {
            if (oldn.e.equals(e)) {
                break;
            }
            oldn = oldn.next;
        }
        if (oldn != null) {
            unlink(oldn);
            return true;
        }
        return false;
    }


    /**
     * удалить и вернуть первый элемент списка
     * @return первый элемент списка
     */
    @Override
    public E removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node<E> oldn = head;
        unlink(oldn);
        return oldn.e;
    }


    /**
     * удалить и вернуть последний элемент списка
     * @return последний элемент списка
     */
    @Override
    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node<E> oldn = tail;
        unlink(oldn);
        return oldn.e;
    }


    /**
     * удалить и вернуть элемент на позиции i
     * @param i позиция
     * @return элемент на позиции i
     */
    @Override
    public E remove(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> oldn = nodeAt(i);
        unlink(oldn);
        return oldn.e;
    }


    /**
     * вернуть первый элемент списка без удаления
     * @return первый элемент списка
     */
    @Override
    public E getFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return head.e;
    }


    /**
     * вернуть последний элемент списка без удаления
     * @return последний элемент списка
     */
    @Override
    public E getLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return tail.e;
    }


    /**
     * вернуть элемент списка на позиции i
     * @param i позиция
     * @return элемент на позиции i
     */
    @Override
    public E get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = nodeAt(i);
        return node.e;
    }


    /**
     * вернуть размер списка
     * @return размер списка
     */
    @Override
    public int size() {
        return size;
    }


    /**
     * вернуть узел на позиции i
     * @param i позиция
     * @return узел на позиции i
     */
    private Node<E> nodeAt(int i) {
        Node<E> node;
        if (i * 2 < size) {
            node = head;
            for (int j = 0; j < i; j++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int j = size - 1; j > i; j--) {
                node = node.prev;
            }
        }
        return node;
    }


    /**
     * итератор для прохода foreach
     * @return итератор
     */
    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            Node<E> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public E next() {
                E e = node.e;
                node = node.next;
                return e;
            }
        };
        return it;
    }
}
