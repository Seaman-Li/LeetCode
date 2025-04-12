package Hashmap;

import java.util.*;

public class LC0049_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);// anagram signature
//            Checks if key exists in map.If not, it uses the lambda k -> new ArrayList<>() to compute a default value (a new list), and puts it in the map.If key already exists, it just returns the existing list.
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
//            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] stringList = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        LC0049_GroupAnagrams sol = new LC0049_GroupAnagrams();

        System.out.println(sol.groupAnagrams(stringList));
    }

}
