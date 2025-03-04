package Stack;

import java.util.Deque;
import java.util.LinkedList;
//Split the input by '/' to get directory names.
//Use a stack to process valid directory names:
//        ".." → Go back (pop stack)
//"." → Ignore (current directory)
//"a" → Valid directory (push to stack)
//Construct the final path from stack elements.
public class LC0071_SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        for (String s : path.split("/")) {
            if (s.equals("..")) {
                if (!stack.isEmpty())
                    stack.pollLast();
            } else if (!s.isEmpty() && !s.equals(".")) {
                stack.addLast(s);// Push valid directory name
            }
        }
        return "/" + String.join("/", stack);
    }


    public static void main(String[] args) {
        LC0071_SimplifyPath solution = new LC0071_SimplifyPath();
        for(String s: "/home//foo/".split("/")){
            System.out.println(s);
        }

//        System.out.println(solution.simplifyPath("/home/"));
    }
}
