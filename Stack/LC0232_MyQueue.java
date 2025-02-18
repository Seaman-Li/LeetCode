package Stack;

import java.util.Stack;


//用2个栈来模拟队列
public class LC0232_MyQueue {

    //分为输入栈和输出栈
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    //构造函数
    public LC0232_MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    //把输入栈的元素全部出栈然后push到输出栈中，输出栈将要输出数据时调用
    private void transferIntoOut(){
        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
    }


    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (outStack.isEmpty()) {
            transferIntoOut();
        }
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(outStack.isEmpty()){
            transferIntoOut();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public static void main(String[] args) {

        LC0232_MyQueue myQueue = new LC0232_MyQueue();

        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);

        int param_1 = myQueue.pop();
        int param_2 = myQueue.peek();

        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(myQueue.empty());

    }



}
