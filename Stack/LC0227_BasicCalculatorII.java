package Stack;

import java.util.Stack;

//    Given a string s which represents an expression, evaluate this expression and return its value.
//    The integer division should truncate toward zero.
//    You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
//    Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
//    Example 1:
//    Input: s = "3+2*2"
//    Output: 7

//note : no parentheses in this problem
public class LC0227_BasicCalculatorII {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';// previous operator, default to '+'

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }

            // When to evaluate:
            // 1. current char is an operator
            // 2. or at the end of the string
            if((!Character.isDigit(c) && c != ' ' || i == s.length() - 1)){
                if(sign == '+'){
                    stack.push(num);
                }else if(sign == '-'){
                    stack.push(-num);
                }else if(sign == '*'){
                    stack.push(stack.pop() * num);
                }else if(sign == '/'){
                    stack.push(stack.pop() / num);
                }
                // Update for next round
                sign = c;
                num = 0;
            }
        }
        // Sum up the stack
        int res = 0;
        for(int val : stack){
            res += val;
        }
        return res;
    }


    public static void main(String[] args) {
        LC0227_BasicCalculatorII calculator = new LC0227_BasicCalculatorII();
        System.out.println(calculator.calculate("2+2*0"));
    }
}
