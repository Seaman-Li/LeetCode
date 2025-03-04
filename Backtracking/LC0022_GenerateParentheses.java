package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC0022_GenerateParentheses {

    //    Use recursion (backtracking) to generate all valid combinations.
//    Maintain:
//    open count: Number of ( used.
//    close count: Number of ) used.
//    Rules:
//    If open < n, we can add (.
//    If close < open, we can add ).
//    Stop when open == close == n.
    List<String> res = new ArrayList<>();
    StringBuilder track = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return res;
    }

    public void backtrack(int open, int close, int n) {
        if (track.length() == 2 * n) {// Base case: valid combination found
            res.add(track.toString());
            return;
        }

        if (open < n) {// Can still add "("
            track.append('(');
            backtrack(open + 1, close, n);
            track.deleteCharAt(track.length() - 1);// Undo choice (Backtrack)
        }
        if (close < open) {// Can still add ")"
            track.append(')');
            backtrack(open, close + 1, n);
            track.deleteCharAt(track.length() - 1);// Undo choice (Backtrack)
        }
    }

    public List<String> generateParenthesisBFS(int n) {
        List<String> res = new ArrayList<>();
        Queue<State> queue = new LinkedList<>();
        queue.add(new State("", 0, 0));

        while (!queue.isEmpty()) {
            State cur = queue.poll();
            if (cur.str.length() == 2 * n) {
                res.add(cur.str);
                continue;
            }

            if (cur.open < n) queue.add(new State(cur.str + "(", cur.open + 1, cur.close));
            if (cur.close < cur.open) queue.add(new State(cur.str + ")", cur.open, cur.close + 1));
        }

        return res;
    }


    class State {
        String str;
        int open, close;

        State(String s, int o, int c) {
            str = s;
            open = o;
            close = c;
        }
    }

    public static void main(String[] args) {
        LC0022_GenerateParentheses sol = new LC0022_GenerateParentheses();
        System.out.println(sol.generateParenthesisBFS(3));
    }
}
