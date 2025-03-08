package my.practice.datastructures.cache;

import my.practice.datastructures.cache.policies.LRUEviction;

public class Main {
    public static void main(String[] args) {
        Cache<Integer,Integer> cache = new Cache<>(new LRUEviction<>(),4);
        cache.put(2,5);
        cache.put(2,7);
        cache.printKeys();
        cache.put(1,4);
        cache.put(3,9);
        cache.put(7,8);
        cache.put(8,66);
        cache.printKeys();
    }
}
