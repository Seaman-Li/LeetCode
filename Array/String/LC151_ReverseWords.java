package Array.String;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class LC151_ReverseWords {
//遍历字符串，用栈存储单词：遍历整个字符串，识别出单词并将它们推入栈中。
//利用栈的特性来反转单词顺序：从栈中弹出元素，因为栈是LIFO（后进先出）的数据结构，这自然地实现了单词的反转。
//构建最终的字符串：从栈中依次弹出单词，同时在单词之间添加一个空格来构建最终的字符串。
    public static String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                word.append(c); // 构建当前单词
            } else if (!word.isEmpty()) {
                stack.push(word.toString()); // 单词结束，压入栈中
                word = new StringBuilder(); // 重置word构建器
            }
        }
        if (!word.isEmpty()) { // 最后一个单词添加到栈中
            stack.push(word.toString());
        }

        // 构建最终的反转单词字符串
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
            if (!stack.isEmpty()) { // 确保最后一个单词后不添加多余的空格
                result.append(" ");
            }
        }

        return result.toString();
    }


//分割字符串：使用 split(" ") 方法分割字符串，但这会导致原字符串中连续的空格被解释为多个空分隔符，结果中包含空字符串。这种方法可以减少手动管理空格和单词边界的复杂性。
//过滤和入栈：遍历分割后的字符串数组，将非空的单词推入栈中。
//从栈中构建最终字符串：利用栈的后进先出（LIFO）特性，构建反转后的字符串。
    public static String reverseWords2(String s){
        String[] words = s.split(" ");
        Stack<String> stack = new Stack<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                stack.push(word);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
            if (!stack.isEmpty()) {
                result.append(" ");
            }
        }
        return result.toString();
    }

//去除首尾及中间多余空格：首先，去除字符串首尾的空格，并将字符串中间多余的空格简化为单一空格。(trim() 方法用于移除字符串首尾的空白字符（包括空格、tab 键、换行符等）)
//分割单词：使用空格将字符串分割成单词数组。(split() 方法基于正则表达式或简单的字符串分隔符，将字符串分割为子字符串数组)
//翻转单词数组：将单词数组翻转。(Collections 工具类 提供了一套静态方法来操作集合对象，这些方法可以用于对集合进行排序、搜索、线程安全包装、不可修改视图创建等)
//重新组合为字符串：将翻转后的单词数组合并成一个新的字符串，单词之间用单个空格分隔。
    public static String reverseWords3(String s) {
        // 去除首尾空格，分割字符串
        String[] words = s.trim().split("\\s+"); // \\s+ 正则表达式匹配一个或多个空格
        Collections.reverse(Arrays.asList(words)); // 翻转字符串数组
        return String.join(" ", words); // 用空格重新拼接字符串
    }

    public static void main(String[] args) {
        String s = "  Let's  take LeetCode contest";

        System.out.println(reverseWords2(s));
    }
}
