package Hashmap;

import java.util.HashMap;

public class LC383_RansomNote {

    //every character in ransomNote must be found in magazine with at least the same count.
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counts = new int[26];
        // Count frequency of each letter in magazine.
        for(char c : magazine.toCharArray()){
            counts[c - 'a']++;
        }
        // Decrement the count for each letter in ransomNote.
        for(char c : ransomNote.toCharArray()){
            //If any letter’s count goes negative, return false.
            if(--counts[c - 'a'] < 0){
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : magazine.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c : ransomNote.toCharArray()){
            if(map.getOrDefault(c, 0) == 0){
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        LC383_RansomNote sol = new LC383_RansomNote();
        System.out.println(sol.canConstruct2("aa", "aab"));
    }


}
