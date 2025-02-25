package Array.String;

//题目要求我们处理退格字符 #，然后比较两个字符串是否相同。
//
//方法 1：使用栈（推荐）
//遍历字符串：
//遇到普通字符，加入栈。
//遇到 #，从栈中弹出一个字符（如果栈非空）。
//处理完两个字符串后，比较它们是否相等。
public class BackSpaceString {
    public static int compareStrings(String s1, String s2) {
        return processString(s1).equals(processString(s2)) ? 1 : 0;
    }

    private static String processString(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s1 = "axx#bb#c";
        String s2 = "axbd#c#c";
        System.out.println(compareStrings(s1, s2)); // 输出: 1
    }
}

