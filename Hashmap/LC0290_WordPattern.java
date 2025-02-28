package Hashmap;

import java.util.HashMap;
import java.util.LinkedList;
//same as LC205
public class LC0290_WordPattern {

    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if (pattern.length() != strings.length)
            return false;
        HashMap<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(strings[i])){
                    return false;
                }
            } else if (map.containsValue(strings[i])) {//map doesn't contain c but map already contains string[i], c and string[i] must correspond one-to-one
                return false;
            }
            map.put(c, strings[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        LC0290_WordPattern sol = new LC0290_WordPattern();
        System.out.println(sol.wordPattern("aaaa", "dog cat cat dog"));
    }
}
