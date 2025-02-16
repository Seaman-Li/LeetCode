package Stack;

import java.util.Stack;

public class LC020_ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else  {
                if (stack.isEmpty()) return false; // No matching open bracket Counterexample("(()")

                char top = stack.pop(); // Get last open bracket

                // Check if the closing bracket matches the last open bracket
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();// If stack is empty, it is valid Counterexample("((())")
    }

    public static void main(String[] args) {
        System.out.println(new LC020_ValidParentheses().isValid("(()"));
    }
}
