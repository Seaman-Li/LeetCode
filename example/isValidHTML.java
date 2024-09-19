package example;

import java.util.Stack;

public class isValidHTML {
    public static boolean isValidHTML(String html) {
        // write code here
        Stack<String> stack = new Stack<>();
        int start = 0;
        while(start < html.length()){
//            先找<再找>
            if(html.charAt(start) == '<'){
                int end = start;
                while(end < html.length() && html.charAt(end) != '>'){
                    end++;
                }
                if(end == html.length()){
                    return false;
                }

                String lable = html.substring(start + 1, end); //提取标签
                //是开始标签就压栈
                if( lable.charAt(0) != '/' && !lable.isEmpty()){
                    stack.push(lable);
                } else if (!lable.isEmpty()) {
                    //是结束标签就要和开始标签比较
                    String endLable = stack.pop();
                    if(!endLable.equals(lable.substring(1))){
                        return false;
                    }

                }else
                    return false;

                start = end;
            }
            start++;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String html = "<div><p></p></div>";
        System.out.println(isValidHTML(html));
    }
}
