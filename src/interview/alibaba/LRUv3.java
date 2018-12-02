package interview.alibaba;

import java.util.LinkedHashMap;
import java.util.Map;

class LinkedhashMapWithCapacity<K,V> extends LinkedHashMap<K,V> {
    private int capacity;

    public LinkedhashMapWithCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return this.size() > this.capacity;
    }
}

public class LRUv3 {
    private LinkedhashMapWithCapacity<Integer,Integer> map;

    public LRUv3(int capacity) {
        this.map = new LinkedhashMapWithCapacity<>(capacity);
    }

    public int get(int key) {
        Integer value = this.map.get(key);
        if (value == null) {
            value = -1;
        } else {
            this.set(key, value);
        }
        return value;
    }

    public void set(int key, int value) {
        if (this.map.containsKey(key))
            this.map.remove(key);
        this.map.get(key);
    }
}