package subhro.sde_sheet.day13_stackAndQueue;

/**
 * Question - https://practice.geeksforgeeks.org/problems/queue-using-stack/1/
 *            https://leetcode.com/problems/implement-queue-using-stacks/
 *
 * Approach - All the approaches will require 2 stacks that can be done either using stack or recursion's stack.
 *            1. Using 2 Stack
 *               A. By making enQueue operation costly.
 *               B. By making deQueue operation costly.
 *
 *            [These below are not done as mostly first 2 ways are needed.]
 *            2. Queue can also be implemented using one user stack and one Function Call
 *            3. Implementation of method 2 using Function Call Stack.
 *
 * Video - 1. Coding Ninja Video
 *         2. https://www.youtube.com/watch?v=3Et9MrMc02A&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=76&ab_channel=takeUforward
 *
 */

import java.util.Stack;
public class QueueUsing2Stack {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int size;

    public QueueUsing2Stack(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void enqueue(int ele){

    }

    public int dequeue(){

    }

    public int front(){

    }

}
