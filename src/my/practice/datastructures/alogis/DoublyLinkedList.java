package my.practice.datastructures.alogis;

public class DoublyLinkedList<E> {
    Node<E> head;
    Node<E> tail;

    public DoublyLinkedList() {
        head = new Node<>(null);
        tail = new Node<>(null);

        head.next = tail;
        tail.prev = head;
    }

    public void addNodeLast(Node<E> n) {
        Node<E> tailPrev = tail.prev;
        tail.prev = n;
        tailPrev.next = n;
        n.prev = tailPrev;
        n.next = tail;
    }

    public void removeNode(Node<E> n) {
        if(n!=null) {
            Node<E> next = n.next;
            Node<E> prev = n.prev;
            prev.next = next;
            next.prev = prev;
        }
    }

    public void addNodeFront(Node<E> n) {
        if(n!=null) {
            Node<E> headNext = head.next;
            head.next = n;
            headNext.prev = n;
            n.next = headNext;
            n.prev = head;
        }
    }

    public boolean isListEmpty() {
        return head.next == tail;
    }

    public Node<E> getFirstNode() {
        if(isListEmpty())
            return null;
        return head.next;
    }

    public Node<E> getLastNode() {
        if(isListEmpty())
            return null;
        return tail.prev;
    }


}
