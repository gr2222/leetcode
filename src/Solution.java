import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        int ruli;
        while (!stack1.empty()) {
            Integer pop = stack1.pop();
            stack2.push(pop);
        }
        ruli = stack2.pop();
        while (!stack2.empty()){
            Integer pop = stack2.pop();
            stack1.push(pop);
        }
        return ruli;
    }
}