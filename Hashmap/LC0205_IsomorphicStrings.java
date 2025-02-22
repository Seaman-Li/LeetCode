package Hashmap;

import java.util.HashMap;
import java.util.Objects;

public class LC0205_IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> charIndexS = new HashMap<>();
        HashMap<Character, Integer> charIndexT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if(!charIndexS.containsKey(s.charAt(i)))
                charIndexS.put(s.charAt(i), i);
            if(!charIndexT.containsKey(t.charAt(i)))
                charIndexT.put(t.charAt(i), i);
            if(!Objects.equals(charIndexS.get(s.charAt(i)), charIndexT.get(t.charAt(i))))
                return false;
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Character> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char schar = s.charAt(i);
            char tchar = t.charAt(i);

            if(charMap.containsKey(schar)){//find if the key-value we already record is the same or not
                if(charMap.get(schar) != tchar)
                    return false;
            } else if (charMap.containsValue(tchar)) {//element never exist in s but already exist in t, return false
                return false;
            }
            charMap.put(schar, tchar);
        }
        return true;
    }

    public static void main(String[] args) {
        LC0205_IsomorphicStrings sol = new LC0205_IsomorphicStrings();
        System.out.println(sol.isIsomorphic2("egg", "adc"));
    }
}
