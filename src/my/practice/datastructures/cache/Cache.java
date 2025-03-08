package my.practice.datastructures.cache;

import my.practice.datastructures.cache.policies.EvictionPolicy;

import java.util.HashMap;
import java.util.Map;

public class Cache<Key,Value> {
    Map<Key,Value> mp;
    EvictionPolicy<Key> evictionPolicy;
    int capacity;

    public Cache(EvictionPolicy<Key> evictionPolicy,int capacity) {
        mp = new HashMap<>();
        this.evictionPolicy = evictionPolicy;
        this.capacity = capacity;
    }

    public void put(Key key, Value value) {
        if(mp.size() == capacity) {
            Key evictedKey = evictionPolicy.evictKey();
            mp.remove(evictedKey);
        }
        mp.put(key,value);
        evictionPolicy.keyAccessed(key);
        System.out.println("KEY HAS BEEN INSERTED");
    }
    public Value get(Key key) {
        Value v = mp.get(key);
        evictionPolicy.keyAccessed(key);
        return v;
    }
    public void printKeys() {
        for(Map.Entry<Key,Value> entry : mp.entrySet()) {
            System.out.println("KEY:"+entry.getKey());
        }
    }
}
