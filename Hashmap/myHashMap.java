package Hashmap;

import java.util.LinkedList;

public class myHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private LinkedList<Entry<K, V>>[] buckets;
    private int size;

    public myHashMap() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        size = 0;
    }

    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

//    private int getBucketIndex(K key) {
//        return (key.hashCode() & 0x7FFFFFFF) % buckets.length;
//    }


    private int getBucketIndex(K key) {
        int hash = key.hashCode();
        return (hash % buckets.length + buckets.length) % buckets.length;
    }


    public void put(K key, V value) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        buckets[index].add(new Entry<>(key, value));
        size++;
        if (size > buckets.length * LOAD_FACTOR) {
            resize();
        }
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) return null;
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) return;
        buckets[index].removeIf(entry -> entry.key.equals(key));
        size--;
    }

    public int size() {
        return size;
    }

    private void resize() {
        LinkedList<Entry<K, V>>[] oldBuckets = buckets;
        buckets = new LinkedList[oldBuckets.length * 2];
        size = 0;
        for (LinkedList<Entry<K, V>> bucket : oldBuckets) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    put(entry.key, entry.value);
                }
            }
        }
    }

    public void printMap() {
        for (int i = 0; i < buckets.length; i++) {
            System.out.print("Bucket " + i + ": ");
            if (buckets[i] != null) {
                for (Entry<K, V> entry : buckets[i]) {
                    System.out.print("[" + entry.key + "，" + entry.value + "] ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        myHashMap<String, Integer> map = new myHashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);
        System.out.println("Value of Apple: " + map.get("Apple"));

        map.put("Apple", 50);
        System.out.println("Contains key 'Banana': " + map.containsKey("Banana"));
//        map.remove("Banana");
        System.out.println("Contains key 'Banana' after removal: " + map.containsKey("Banana"));
        System.out.println("Map Size: " + map.size());
        map.printMap();
    }
}

