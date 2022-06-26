package subhro.sde_sheet.day13_stackAndQueue;

public class StackUsingArray {
    private int[] data;
    private int front;

    public StackUsingArray(int size){
        data = new int[size];
        front = -1;
    }

    public void push(int ele){
        if(front==data.length-1){
//            System.out.println("Array is full.");
//            return;
            doubleCapacity();
        }

        data[++front] = ele;
    }

    private void doubleCapacity(){
        System.out.println("Making Size Double.");
        int[] temp = data;
        data = new int[2*temp.length];
        for(int i=0; i<temp.length; i++){
            data[i] = temp[i];
        }
    }

    public int top(){
        if(front==-1){
            System.out.println("No element is there.");
            return -1;
        }else{
            return data[front];
        }
    }

    public int pop(){
        if(front==-1){
            System.out.println("No element is there.");
            return -1;
        }else{
            int ele = data[front];
            data[front] = 0;
            front--;
            return ele;
        }
    }

    public boolean isEmpty(){
        return front==-1;
    }

    public int size(){
        return front+1;
    }
}
