package other;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stack1 = new Stack<>();  //input
    Stack<Integer> stack2 = new Stack<>();  //output

    public void push(int node){
        stack1.push(node);

        if(stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public int pop() {
        return stack2.pop();
    }
}
