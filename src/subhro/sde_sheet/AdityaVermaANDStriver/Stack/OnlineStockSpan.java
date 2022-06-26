package subhro.sde_sheet.AdityaVermaANDStriver.Stack;

import java.util.Stack;

/**
 * Question - https://leetcode.com/problems/online-stock-span/
 *
 */
public class OnlineStockSpan {
    //Most Optimal Solution
    class Pair{
        int number;
        int index;

        Pair(int number, int index){
            this.number = number;
            this.index = index;
        }
    }

    Stack<Pair> stack;
    int count=0;

    public OnlineStockSpan() {
        stack = new Stack<>();
    }

    public int next(int price) {
        count++;
        while(stack.size()>0 && stack.peek().number<=price){
            stack.pop();
        }

        int req = 0;
        if(stack.size()>0){
            req = count - stack.peek().index;
        }else{
            req = count;
        }
        stack.push(new Pair(price, count));
        return req;
    }


    //SECOND Approach using HashMap. This can be the brute force approach
    /*HashMap<Integer, Integer> map;
    Stack<Integer> stack;
    int count=0;

    public OnlineStockSpan() {
        map = new HashMap<>();
        stack = new Stack<>();
    }

    //Main Logic
    public int next(int price) {
        count++;
        map.put(price, count);
        while(stack.size()>0 && stack.peek()<=price){
            stack.pop();
        }

        int req = 0;
        if(stack.size()>0){
            int pos = map.get(stack.peek());
            req = count - pos;
        }else{
            //If this comes in else block, then it means that all the elements are smaller then current price
            req = count;
        }
        stack.push(price);
        return req;
    }*/
}
