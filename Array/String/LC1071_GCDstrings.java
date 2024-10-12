package Array.String;

public class LC1071_GCDstrings {

//    寻找两个字符串的最大公因子，这与寻找两个数字的最大公约数（GCD）类似
//    利用最大公约数 (GCD) 的概念：
//
//如果一个字符串 s 可以被分解为若干个相同的子字符串 t 的重复，那么 s 的长度必须是 t 的长度的倍数。
//因此，如果 t 是 str1 和 str2 的最长公因子，那么 str1 和 str2 的长度的最大公约数（GCD）应该是 t 长度的倍数。
//计算长度的 GCD：
//
//首先计算 str1 和 str2 长度的最大公约数。
//然后检查这个长度是否可以作为两个字符串的公因子，即检查用这个长度的字符串能否重复若干次得到完整的 str1 和 str2。
//验证最大公因子：
//
//使用得到的 GCD 长度作为子串长度从 str1 或 str2 中提取子串，并验证这个子串重复相应次数后是否能完全构成 str1 和 str2。
    public static String gcdOfStrings(String str1, String str2) {
        // 如果两个字符串拼接后不等于反向拼接，则不存在公共子串
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // 计算两个字符串长度的最大公约数
        int gcdLength = gcd(str1.length(), str2.length());

        // 返回其中任意字符串的前gcdLength个字符作为最大公因子
        return str1.substring(0, gcdLength);
    }

    // 辅助函数，用于计算两个数的最大公约数
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("abcabc", "abc"));
    }
}
