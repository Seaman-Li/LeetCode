package Hashmap;

public class LC0242_ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;

    }
    public static void main(String[] args) {
        LC0242_ValidAnagram sol = new LC0242_ValidAnagram();
        System.out.println(sol.isAnagram("anagram", "nagaram"));
    }
}
