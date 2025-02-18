package Array.String;

public class LC0028_findIndexof1stOccurrenceString {

    public static void main(String[] args) {
        String haystack = "ABAABABCAA";
        String needle = "ABABC";
        System.out.println(strStr(haystack,needle));
        System.out.println(strStr2(haystack,needle));
    }

    public static int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        if(haystack.isEmpty()) return -1;

        int[] next = computeLPS(needle);
        int i = 0, j = 0;

        while(i < haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;

                if(j == needle.length()){
                    return i - j;
                }
            } else if (j > 0) {//处理不匹配
                j = next[j - 1];
            }else{
                i++;
            }
        }
        return -1;
    }

    public static int strStr2(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        if(haystack.isEmpty()) return -1;

        String cur = needle + '#' + haystack;
        int M = cur.length();
        int[] lps =  computeLPS(cur);

        for (int i = needle.length() + 1; i < cur.length(); i++) {
            if (lps[i] == needle.length()) {
                return  ( i - 2 * needle.length() );
            }
        }
        return -1;
    }

//    针对模式串（pattern）本身，计算每个前缀的前缀和后缀的最长公共元素的长度。
    private static int[] computeLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0]总是0

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
