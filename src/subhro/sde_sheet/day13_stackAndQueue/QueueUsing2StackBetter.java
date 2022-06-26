package subhro.sde_sheet.day13_stackAndQueue;

import java.util.Stack;

/**
 * Question - https://leetcode.com/problems/implement-queue-using-stacks/submissions/
 */
public class QueueUsing2Stack {

    Stack<Integer> s1;
    Stack<Integer> s2;
    int size;

    public QueueUsing2Stack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {

        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }

        s1.add(x);

        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }

        size++;
    }

    public int pop() {
        if(size==0){
            return -1;
        }
        size--;
        return s1.pop();
    }

    public int peek() {
        if(size==0){
            return -1;
        }
        return s1.peek();
    }

    public boolean empty() {
        return size==0;
    }
}
