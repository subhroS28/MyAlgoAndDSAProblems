package subhro.sde_sheet.day13_stackAndQueue;

import subhro.sde_sheet.Other.LinkedList.IMPL.Node;

public class StackUsingLinkedList {

    private Node head;
    private int size;

    public StackUsingLinkedList(){
        head = null;
        size = 0;
    }

    public void push(int data){
        Node newEle = new Node(data);
        newEle.next = head;
        head = newEle;
        size++;
    }

    public int top(){
        if(head == null){
            System.out.println("No element is there.");
            return -1;
        }

        return head.data;
    }

    public int pop(){
        if(head==null){
            System.out.println("No element is there.");
            return -1;
        }

//        Node removedElem = head;
//        Node newHead = head.next;
//        head.next = null;
//        head = newHead;
//        size--;
//        return removedElem.data;
        int ele = head.data;
        head= head.next;
        size--;
        return ele;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public int size(){
        return size;
    }
}
