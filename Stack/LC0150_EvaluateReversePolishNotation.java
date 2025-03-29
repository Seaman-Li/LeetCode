package Stack;

import java.util.Stack;

public class LC0150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if(isOperator(token)){
                int b = stack.pop();// second operand
                int a = stack.pop();// first operand
                stack.push(apply(a, b, token));
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private int apply(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b; // ⚠️ order matters
            case "*": return a * b;
            case "/": return a / b; // ⚠️ truncate toward zero
        }
        return 0;
    }

    public static void main(String[] args) {
        LC0150_EvaluateReversePolishNotation solution = new LC0150_EvaluateReversePolishNotation();
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(solution.evalRPN(tokens));
    }
}
