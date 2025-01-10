package Map.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC017_LetterCombination {
    // 数字到字母的映射
    private static final String[] KEYS = {
            "",     // 0 不使用
            "",     // 1 不使用
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result; // 如果输入为空，返回空列表
        }

        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder combination, String digits, int index) {
        // 如果组合完成，加入结果
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }

        // 获取当前数字对应的字母
        String letters = KEYS[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            // 添加当前字母
            combination.append(letter);
            // 递归处理下一个数字
            backtrack(result, combination, digits, index + 1);
            // 回溯，移除最后一个字母
            combination.deleteCharAt(combination.length() - 1);
        }
    }



}
