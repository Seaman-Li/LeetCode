package Array.String;

public class LC1768_mergeStringsAlternately {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "pq";
        System.out.println(mergeAlternately(s1, s2));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            merged.append(word1.charAt(i++));
            merged.append(word2.charAt(j++));
        }
        while (i < word1.length()) {
            merged.append(word1.charAt(i++));
        }
        while (j < word2.length()) {
            merged.append(word2.charAt(j++));
        }
        return merged.toString();
    }
}
