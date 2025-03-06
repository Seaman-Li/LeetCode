package Hashmap;

import java.util.LinkedList;
//Why Use LinkedList<Entry<K, V>>[] buckets; to Handle Hash Collisions?
//Problem: Hash Collisions
//A HashMap uses a hash function to map keys to an array index (bucket).
//Different keys may hash to the same bucket index (this is called a collision).
//Example: If hash("Apple") % 10 = 2 and hash("Orange") % 10 = 2, both "Apple" and "Orange" will go into bucket index 2.
//Solution: Using a Linked List in Each Bucket
//Instead of storing only one value per bucket, we store a linked list of key-value pairs (Entry<K, V>) in each bucket.
//If two keys collide (i.e., map to the same index), we chain them together in a linked list.
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

//Even though different keys have different hash codes, they can still map to the same bucket index due to hash collisions.
//How Does This Happen?
//    The hash code (hashCode()) of an object is not necessarily unique.
//    Java's hashCode() function returns an integer (int), but the number of buckets is usually much smaller.
//    When we compute the bucket index, we take the modulus (%) of the hashCode() with the bucket array length.
//    If two different hash codes produce the same remainder after the modulus operation, they collide in the same bucket.
    private int getBucketIndex(K key) {

        int hash = key.hashCode();
        return (hash % buckets.length + buckets.length) % buckets.length;//use this to handle negative hash codes (remainder)
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

