package interview.alibaba;

import java.util.*;

public class LRUv1 {
    private int size = 0;
    private LinkedHashMap<Integer, Integer> map;


    public LRUv1(int size) {
        this.size = size;
        this.map = new LinkedHashMap<>();
    }

    public int get(int key) {
        Integer value = map.get(key);

        if(value == null) {
            return -1;
        } else {
            this.set(key, value);
        }
        return value;
    }

    public void set(int key, int value) {
        if(this.map.containsKey(key)) {
            this.map.remove(key);
        } else if(this.map.size() == this.size) {
            Iterator<Integer> it = this.map.keySet().iterator();
            it.next();
            it.remove();
        }

        map.put(key, value);
    }
}
