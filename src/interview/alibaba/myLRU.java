package interview.alibaba;

import java.util.HashMap;

public class myLRU<K, V> {
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

    private HashMap<K,Node<K,V>> map;
    private Node<K, V> headNode; // oldest
    private Node<K, V> tailNode; // recently
    private int currentSize ;
    private int capicity;

    public myLRU(int capicity) {
        this.map = new HashMap<>();
        this.headNode = null;
        this.tailNode = null;
        this.currentSize = 0;
        this.capicity = capicity;
    }

    public V get(K key) {
        if(!this.map.containsKey(key)) {
            return null;
        }

        Node<K, V> tempNode = this.map.get(key);

        if(tailNode != null && tailNode.key == tempNode.key) {
            return tempNode.value;
        }

        if(headNode != null && headNode.key == tempNode.key) {
            headNode = headNode.next;
            headNode.previous = null;
        }else{
            tempNode.next.previous =tempNode.previous;
            tempNode.previous = tempNode.next;
        }

        tempNode.previous = tailNode;
        tailNode.next = tempNode;
        tailNode = tempNode;

        return tempNode.value;
    }

    public void set(K key, V value) {
        if(map.containsKey(key)) {
            return;
        }


        Node<K, V> tmpNode = new Node<>(null, null, key, value);

        map.put(key, tmpNode);

        if(headNode == null || tailNode == null) {
            headNode = tmpNode;
            tailNode = tmpNode;
            return;
        }

        if(this.currentSize == capicity) {
            map.remove(headNode.key);
            headNode = headNode.next;
            headNode.previous = null;
            currentSize--;
        }

        tailNode.next =tmpNode;
        tmpNode.previous = tailNode;
        tailNode = tmpNode;
        currentSize++;

    }
}
