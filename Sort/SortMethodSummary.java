package Sort;

import java.util.*;

public class SortMethodSummary {

    class Person {
        String name;
        int age;
    }
    public static void main(String[] args) {

        //1. Sorting a Primitive Array (e.g., int[])
        int[] arr = {5, 2, 8, 1};
        Arrays.sort(arr);  // Ascending


        //2. Sorting an Object Array (e.g., Integer[])
        Integer[] arr1 = {5, 2, 8, 1};
        Arrays.sort(arr1, (a, b) -> a - b);  // Ascending using lambda
        Arrays.sort(arr1, Comparator.reverseOrder());  // Descending


        //3. Sorting a 2D Array (like in interval )
        int[][] intervals = {{1,3}, {2,6}, {8,10}};
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));           // by first element
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));             // by second element

        //4. Sorting a List<Integer>
        List<Integer> list = Arrays.asList(5, 1, 4, 2);
        Collections.sort(list);  // Ascending
        list.sort(Comparator.reverseOrder());  // Descending

        //5. Sorting a List<MyObject> by Field
        List<Person> people = new ArrayList<>();
        people.sort((a, b) -> a.age - b.age); // Ascending by age
        people.sort(Comparator.comparingInt(p -> p.age)); // Same, more readable

        // By name (String)
        people.sort(Comparator.comparing((Person p) -> p.name)); // Ascending
        people.sort(Comparator.comparing((Person p) -> p.name).reversed()); // Descending

        //6. Chained Sorting (e.g., sort by age, then name)
        people.sort(
                Comparator.comparingInt((Person p) -> p.age)
                        .thenComparing(p -> p.name)
        );


    }
}
