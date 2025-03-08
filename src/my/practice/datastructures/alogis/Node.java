package my.practice.datastructures.alogis;

public class Node<E> {
    Node<E> next;
    Node<E> prev;

    E element;

    public Node(E element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }

    public E getElement() {
        return this.element;
    }
}
