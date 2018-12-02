package interview.alibaba;

import java.util.HashMap;
import java.util.Hashtable;

public class LRUv2<K, V> {
    class Node<T, U> {
        Node<T, U> previous;
        Node<T, U> next;
        T key;
        U value;

        public Node(Node<T, U> previous, Node<T, U> next, T key, U value) {
            this.previous = previous;
            this.next = next;
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<K, Node<K, V>> cache;
    private Node<K, V> leastRecentlyUsed;
    private Node<K, V> mostRecentlyUsed;
    private int maxSize;
    private int currentSize;

    public LRUv2(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        leastRecentlyUsed = new Node<>(null, null, null, null);
        mostRecentlyUsed = leastRecentlyUsed;
        cache = new HashMap<>();
    }

    public V get(K key) {
        Node<K, V> tmpNode = cache.get(key);

        if(tmpNode == null) {
            return null;
        } else if(tmpNode.key == mostRecentlyUsed.key) {
            return mostRecentlyUsed.value;
        }

        Node<K,V> nextNode = tmpNode.next;
        Node<K,V> previousNode = tmpNode.previous;

        if(tmpNode.key == leastRecentlyUsed.key) {
            nextNode.previous = null;
            leastRecentlyUsed = nextNode;
        } else if(tmpNode.key != mostRecentlyUsed.key) {
            previousNode.next = nextNode;
            nextNode.previous =previousNode;
        }

        tmpNode.previous = mostRecentlyUsed;
        mostRecentlyUsed.next = tmpNode;
        mostRecentlyUsed = tmpNode;
        mostRecentlyUsed.next = null;

        return tmpNode.value;
    }

    public void put(K key, V value) {
        if(cache.containsKey(key)) {
            return;
        }

        Node<K, V> tmpNode = new Node<>(null, null, key, value);

        mostRecentlyUsed.next = tmpNode;
        cache.put(key, tmpNode);
        mostRecentlyUsed = tmpNode;

        if(currentSize == maxSize) {
            cache.remove(leastRecentlyUsed.key);
            leastRecentlyUsed = leastRecentlyUsed.next;
            leastRecentlyUsed.previous = null;
        } else if(currentSize < maxSize) {
            if(currentSize == 0) {
                leastRecentlyUsed = tmpNode;
            }
            currentSize++;
        }
    }


}
