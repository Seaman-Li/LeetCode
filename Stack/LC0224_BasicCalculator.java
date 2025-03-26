package Stack;

import java.util.Stack;

public class LC0224_BasicCalculator {

//    Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
//    Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
//    Example 1:
//    Input: s = "1 + 1"
//    Output: 2

    public int calculate(String s) {
        int res = 0;
        int curNum = 0;
        int sign = 1;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curNum = curNum * 10 + c - '0';// Build multi-digit number
            } else if (c == '+') {
                res += sign * curNum;
                sign = 1;
                curNum = 0;
            }else if(c == '-'){
                res += sign * curNum;
                sign = -1;
                curNum = 0;
            }else if(c == '('){ // Push current result and sign to stack for later
                stack.push(res);
                stack.push(sign);
                // Reset for inner expression
                res = 0;
                sign = 1;
            }else if(c == ')'){
                res += sign * curNum;
                curNum = 0;
                res *= stack.pop();// sign before the parenthesis
                res += stack.pop(); // result calculated before parenthesis
            }
        }
        return res + sign * curNum; // Add any remaining number
    }

    public static void main(String[] args) {
        LC0224_BasicCalculator calculator = new LC0224_BasicCalculator();
        System.out.println(calculator.calculate("-(2+2)"));
    }

}
