package subhro.sde_sheet.Other.Queue;

import subhro.sde_sheet.Other.LinkedList.IMPL.Node;

public class QueueUsingLinkedList {

    private Node front;
    private Node rear;
    private int size;

    public QueueUsingLinkedList(){
        front = null;
        rear = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void enqueue(int ele){
        Node newElement = new Node(ele);
        size++;
        if(size==0){
            front = newElement;
            rear = newElement;
        }else{
            rear.next = newElement;
            rear = newElement;
        }
    }

    public int dequeue(){
        if(size==0){
            System.out.println("No elements are there.");
            return -1;
        }

        int ele = front.data;
        front = front.next;
        size--;
        if (size==0){
            rear = null;
        }
        return ele;
    }

    public int front(){
        if(size==0){
            System.out.println("No elements are there.");
            return -1;
        }
        return front.data;
    }
}
