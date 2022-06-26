package subhro.sde_sheet.Other.Queue;

import subhro.sde_sheet.Other.LinkedList.IMPL.Node;

/**
 * CODING NINJAS CODE
 */
public class QueueUsingLinkedList2 {

    Node front;
    Node rear;
    int size;


    public QueueUsingLinkedList2() {
        //Implement the Constructor
        front=null;
        rear=null;
        size=0;
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() {
        //Implement the getSize() function
        return size;
    }


    public boolean isEmpty() {
        //Implement the isEmpty() function
        return size==0;
    }


    public void enqueue(int data) {
        //Implement the enqueue(element) function
        Node n = new Node(data);
        size++;
        if(rear==null){
            front=n;
            rear=n;
        }else{
            rear.next=n;
            rear=rear.next;
        }
    }


    public int dequeue() {
        //Implement the dequeue() function
        if(front==null){
            return -1;
        }else{
            size--;
            int res = front.data;
            front=front.next;
            if(front==null){
                rear=null;
            }
            return res;
        }
    }


    public int front() {
        //Implement the front() function
        if(front==null){
            return -1;
        }else{
            return front.data;
        }
    }
}
