package Hashmap;

import java.util.LinkedList;

class myHashSet<T> {
    private static final int SIZE = 1000;  // Bucket size
    private LinkedList<T>[] buckets;

    public myHashSet() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hashFunction(T key) {
//        return Math.abs(key.hashCode()) % SIZE;  // Hash function
        //use(hash % SIZE + SIZE) % SIZE instead of abs to handle overflow of abs(Integer.MIN_VALUE)
        return (key.hashCode() % SIZE + SIZE) % SIZE;
    }

    public void add(T key) {
        int index = hashFunction(key);
        if (!buckets[index].contains(key)) {
            buckets[index].add(key);
        }
    }

    public void remove(T key) {
        int index = hashFunction(key);
        buckets[index].remove(key);
    }

    public boolean contains(T key) {
        int index = hashFunction(key);
        return buckets[index].contains(key);
    }

    public static void main(String[] args) {
        myHashSet<Integer> intSet = new myHashSet<>();
        intSet.add(1);
        intSet.add(2);
        System.out.println(intSet.contains(1)); // true
        System.out.println(intSet.contains(3)); // false
        intSet.add(2);
        System.out.println(intSet.contains(2)); // true
        intSet.remove(2);
        System.out.println(intSet.contains(2)); // false

        System.out.println("----");

        myHashSet<String> stringSet = new myHashSet<>();
        stringSet.add("apple");
        stringSet.add("banana");
        System.out.println(stringSet.contains("apple")); // true
        System.out.println(stringSet.contains("cherry")); // false
        stringSet.remove("apple");
        System.out.println(stringSet.contains("apple")); // false
    }
}
