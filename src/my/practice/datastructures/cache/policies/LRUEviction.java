package my.practice.datastructures.cache.policies;

import my.practice.datastructures.alogis.DoublyLinkedList;
import my.practice.datastructures.alogis.Node;

import java.util.HashMap;
import java.util.Map;

public class LRUEviction<Key> implements EvictionPolicy<Key>{
    DoublyLinkedList<Key> dll;
    Map<Key, Node<Key>> mp;

    public LRUEviction() {
        dll = new DoublyLinkedList<>();
        mp = new HashMap<>();
    }
    @Override
    public void keyAccessed(Key key) {
        if(mp.containsKey(key)) {
            Node<Key> n = mp.get(key);
            dll.removeNode(n);
            dll.addNodeFront(n);
        }
        else {
            Node<Key> newNode = new Node<>(key);
            dll.addNodeFront(newNode);
            mp.put(key,newNode);
        }
    }

    @Override
    public Key evictKey() {
        Node<Key> node = dll.getLastNode();
        if(node == null)
            return null;
        dll.removeNode(node);
        return node.getElement();
    }
}
