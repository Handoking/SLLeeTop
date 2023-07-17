package stack_deque;

import java.util.Stack;

/**
 * @program: SLLeeTop
 * @description: 栈实现队列
 * @author: shileilei
 * @date: 2023-07-17 22:37
 **/
public class StackToQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public StackToQueue() {
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int s = stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return s;
    }

    public int peek() {
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int p = stack2.peek();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return p;
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}
