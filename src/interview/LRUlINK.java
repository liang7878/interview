package interview;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUlINK<K, V> extends LinkedHashMap<K,V> {
    private final int MAX_CACHE_SIZE;

    public LRUlINK(int cache) {
        super((int)Math.ceil(cache/0.75) + 1, 0.75f, true);
        MAX_CACHE_SIZE = cache;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_CACHE_SIZE;
    }
}
