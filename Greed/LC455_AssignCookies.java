package Greed;

import java.util.Arrays;

public class LC455_AssignCookies {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1, 1};
        System.out.println(findContentChildren(g, s));
    }
//按照孩子的满足度从小到大排序，饼干从小到大排序，尽可能用最小的饼干满足需求最小的孩子，这样可以留下更大的饼干去尝试满足需求更大的孩子。
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int childIndex = 0, cookieIndex = 0;
        while (childIndex < g.length && cookieIndex < s.length) {
            if (s[cookieIndex] >= g[childIndex]) {
                // 当前饼干可以满足当前孩子
                childIndex++;
            }
            // 移动饼干指针，尝试下一块饼干
            cookieIndex++;
        }
        return childIndex;
    }

}
