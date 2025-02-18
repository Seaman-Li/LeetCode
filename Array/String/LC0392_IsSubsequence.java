package Array.String;

public class LC0392_IsSubsequence {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahcgdb";
        LC0392_IsSubsequence sol = new LC0392_IsSubsequence();
        System.out.println(sol.isSubsequence(s, t));
    }

//初始化两个指针：indexS 和 indexT 分别为 s 和 t 的指针，初始值都设置为 0。
//遍历字符串 t：使用 indexT 遍历字符串 t。
//当 s[indexS] 等于 t[indexT] 时，将 indexS 移动到下一个位置。
//indexT 总是在每次循环时增加，以遍历整个字符串 t。
//检查是否找到了整个 s：如果 indexS 等于 s.length()，意味着 s 中的所有字符都按顺序在 t 中找到了，因此 s 是 t 的子序列。

    public boolean isSubsequence(String s, String t) {
        int indexS = 0, indexT = 0;
        while (indexT < t.length()) {
            if (indexS < s.length() && s.charAt(indexS) == t.charAt(indexT)) {
                indexS++; // 找到匹配的字符，移动 `s` 的指针
            }
            indexT++; // `t` 的指针总是移动
        }
        return indexS == s.length(); // 如果 `s` 的所有字符都被遍历完，则它是子序列
    }
}
