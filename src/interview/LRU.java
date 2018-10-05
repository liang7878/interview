package interview;

import java.util.HashMap;
import java.util.Map;

public class LRU<K, V> {
    private final int MAX_CACHE_SIZE;
    private Entry first;
    private Entry last;

    private HashMap<K, Entry<K,V>> hashMap;

    public LRU(int cacheSize) {
        MAX_CACHE_SIZE = cacheSize;
        hashMap = new HashMap<>();
    }

    public void put(K key, V value) {
        Entry entry = getEntry(key);
        if(entry == null) {
            if(hashMap.size() >= MAX_CACHE_SIZE) {
                hashMap.remove(last.key);
                removeLast();
            }
            entry = new Entry();
            entry.key = key;
        }

        entry.value = value;
        moveToFirst(entry);
        hashMap.put(key, entry);
    }

    public V get(K key) {
        Entry<K, V> entry = getEntry(key);
        if(entry == null) return null;
        moveToFirst(entry);
        return entry.value;
    }

    public void remove(K key) {
        Entry entry = getEntry(key);
        if(entry != null) {
            if(entry.pre != null) entry.pre.next = entry.next;
            if(entry.next != null) entry.next.pre = entry.pre;
            if(entry == first) first = entry.next;
            if(entry == last) last = entry.pre;
        }
        hashMap.remove(key);
    }

    private void moveToFirst(Entry entry) {
        if(entry == first) return;
        if(entry.pre != null) entry.pre.next = entry.next;
        if(entry.next!= null) entry.next.pre = entry.pre;
        if(entry == last) last= entry.pre;

        if(first == null || last == null) {
            first = last = entry;
            return;
        }

        entry.next = first;
        first.pre = entry;
        first = entry;
        entry.pre = null;
    }

    private void removeLast() {
        if(last != null) {
            last = last.pre;
            if(last == null) first = null;
            else last.next = null;
        }
    }

    private Entry<K, V> getEntry(K key) {
        return hashMap.get(key);
    }

    class Entry<K, V> {
        public Entry pre;
        public Entry next;
        public K key;
        public V value;
    }
}
