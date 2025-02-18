package Stack;

import java.util.Stack;

public class LC0394_DecdoeStrings {

    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();  //存放重复次数
        Stack<String> stringStack = new Stack<>();  //存放临时字符串
        String currentString = "";  //累积字符串
        int k = 0;  //累积器，循环次数

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //当遇到数字时，解析完整的数字（可能有多位），并将其推入 countStack。
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // 当遇到左方括号 [ 时，将当前的数字和之前累积的字符串分别推入对应的栈，然后重置这些累积器。
                countStack.push(k);
                stringStack.push(currentString);
                currentString = "";
                k = 0;
            } else if (ch == ']') {  //当遇到右方括号 ] 时，从 stringStack 弹出字符串，从 countStack 弹出次数，将字符串重复指定次数，然后附加到弹出字符串之前的内容上。
                StringBuilder temp = new StringBuilder(stringStack.pop());
                int repeatTimes = countStack.pop();
                for (int j = 0; j < repeatTimes; j++) {
                    temp.append(currentString);
                }
                currentString = temp.toString();
            } else {//如果是字母，则累积到当前字符串。
                currentString += ch;
            }
        }
        return currentString;
    }

    //把string替换为StringBuilder来提升性能，如果使用 String 类型来存储 currentString，每次添加操作都会创建新的字符串对象，这在循环或递归过程中可能导致大量不必要的内存分配和释放，从而降低程序的效率。
    public static String decodeStringStringBuilder(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(new StringBuilder(currentString));
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder temp = stringStack.pop();
                int repeatTimes = countStack.pop();
                for (int j = 0; j < repeatTimes; j++) {
                    temp.append(currentString);
                }
                currentString = temp;
            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        String s = "2[a]2[bc]";
        System.out.println(decodeString(s));
    }
}
