package Array.String;

public class KMP {
    public static void brutalSearch(String txt, String pat) {
        int M = pat.length();
        int N = txt.length();

        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if (j == M) { // 如果完成了模式字符串的所有比较
                System.out.println("Pattern found at index " + i);
            }
        }
    }

//    KMP算法的核心思想确实是针对模式串的结构进行优化，以减少在文本搜索中的不必要比较。
//    当模式串中的前缀和后缀有相同的内容时，KMP算法利用这一点，通过其预处理出的最长公共前后缀表（LPS表）来跳过已经确定匹配的部分。
//    这样，当发生不匹配事件时，算法可以利用之前的匹配信息，避免从模式串的开始重新匹配，而是从最有可能成功的位置继续匹配，从而大幅提高搜索效率。
//    以模式串 "ABCDABD" 为例，lps=[0, 0, 0, 0, 1, 2, 0]在第七个字符 'D'（索引 6）与文本时发生不匹配时，(此时已得知文本串已存在ABCDAB)，这时无需从头部的A重新开始匹配
//    而是根据部分匹配表lps[6-1]=2（Longest Prefix which is also Suffix）得知此时串"ABCDAB" 中的后两个字符 "AB" 形成了最长的相同前后缀，我们可以保证这两个字符已经匹配,所以可以直接跳过这2位从C开始再匹配
//    避免重复匹配：
//      如果我们将 j 重置为 0，将重新开始匹配，这意味着尝试将 "ABCDABD" 的 'A' 对齐到文本中当前的检查点之后的位置。
//      但我们已经知道，由于 'D' 之前的 "ABCDAB" 中的后两个字符 "AB" 形成了最长的相同前后缀，我们可以保证这两个字符已经匹配了。
//    利用已知匹配：
//      由于 "AB" 已经是一个确认的匹配，我们不需要重新检查这部分。通过将 j 设置为 2，我们直接跳过这两个字符，开始检查下一个潜在的匹配点。
//      这样做的结果是，模式串中的 'C'（j = 2）现在将与文本中相应的位置进行比较，这是继续寻找完整匹配的下一个逻辑步骤。
    public static int kmpSearch(String txt, String pat) {
        int M = pat.length();
        int N = txt.length();

        // 部分匹配表
        int[] lps = new int[M];
        computeLPSArray(pat, M, lps);

        int i = 0; // txt的索引
        int j = 0; // pat的索引
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;

                //检查完整匹配,当发现完全匹配后，下一步应该从模式串的lps[j - 1]位开始匹配
                if (j == M) {
                    System.out.println("Found pattern at index " + (i - j));
                    j = lps[j - 1];
                }
            } else if (j > 0) {//处理不匹配
                //表示之前有部分匹配发生，根据 LPS 表回退 j 到 lps[j - 1]。这一步利用之前的匹配结果，避免从模式串的开头重新开始匹配，从而跳过一些已知不会成功的匹配尝试。
                j = lps[j - 1];
            }else{
                // j 为 0的情况，这表示模式串的第一个字符就没有匹配成功，简单地将 i 增加 1，即在文本中向前移动，开始新的匹配尝试。
                i++;
            }

        }
        return -1; // 如果没有找到模式
    }

//    通过拼接 pattern、分隔符和 text 来构建一个新字符串，然后计算这个新字符串的 lps 数组，通过这个数组来确定 pattern 在 text 中的所有匹配位置。
//    这种方法可能更直观，但是对于非常长的文本，这种方法可能不如直接应用 KMP 算法高效，因为它需要处理更长的字符串。
//    分隔符 # 起到一个重要作用。它确保在 pattern 和 text 之间创建一个明确的界限，这意味着在计算 lps 数组时，任何与 pattern 完全匹配的段必须完全位于 pattern 的范围内或完全位于 text 的范围内，且 lps 数组的匹配长度不能跨越这个界限。
//    因此，即使 text 中包含与 pattern 长度相同的子串，这些子串也不会影响到 pattern 的 lps 计算，除非它们完全与 pattern 相同并且恰好出现在 cur 中 pattern 之后的部分。
    public static void findOccurrences(String text, String pattern) {
        String cur = pattern + '#' + text;
        int M = cur.length();
        int[] lps = new int[M];
        computeLPSArray(cur, M, lps);
        for (int i = pattern.length() + 1; i < cur.length(); i++) {
            if (lps[i] == pattern.length()) {
                //计算公式为startIndex = (i - patternLength  + 1) - (patternLength  + 1) = i - 2 * patternLength
                //i - patternLength  + 1是pattern在cur中开始的位置
                //然后再减去patternLength和的长度，即(patternLength  + 1)
                System.out.println("Found pattern at index " + (i - 2 * pattern.length()));
            }
        }
    }

    public static void computeLPSArray(String pat, int M, int[] lps) {
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0]总是0

        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
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
    }

    public static void main(String[] args) {

        String txt = "ABABDABABCA";
        String pat = "ABABC";

        kmpSearch(txt, pat);
        findOccurrences(txt, pat);
    }
}
