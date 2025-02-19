package Array.String;

public class LC0859_BuddyStrings {

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if(s.equals(goal)) {
            // 如果 s 和 goal 相等，则必须有重复字符（如 "aa"）s 和 goal 是完全相同的字符串。在这种情况下，我们需要检查是否可以交换某两个字符后仍然得到相同的字符串。
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
                if (count[c - 'a'] > 1) return true;
            }
            return false; // 没有重复字符，不可能交换后相等
        }

        // 找到所有不同字符的位置
        int first = -1, second = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (first == -1) first = i;
                else if (second == -1) second = i;
                else return false; // 超过两个不同字符，不可能交换后相等
            }
        }

        // 必须有且只有两个不同的字符，并且能通过交换匹配
        return second != -1 && s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first);
    }
}
