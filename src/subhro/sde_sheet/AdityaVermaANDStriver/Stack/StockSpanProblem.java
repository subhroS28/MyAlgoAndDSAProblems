package subhro.sde_sheet.AdityaVermaANDStriver.Stack;

import java.util.Stack;

/**
 * THis question is same as Online Stock Span
 * Question - https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1/#
 *
 * Blog - https://www.geeksforgeeks.org/the-stock-span-problem/
 */
public class StockSpanProblem {
    static class Pair{
        int number;
        int index;

        Pair(int number, int index){
            this.number = number;
            this.index = index;
        }
    }

    public static int[] calculateSpan(int price[], int n){
        int len=n;
        int[] nsl = new int[len];
        Stack<Pair> stack = new Stack<>();
        for(int i=0; i<len; i++){
            while(stack.size()>0 && stack.peek().number<=price[i]){
                stack.pop();
            }

            if(stack.size()==0){
                nsl[i] = i+1;
            }else{
                nsl[i] = i - stack.peek().index;
            }

            stack.push(new Pair(price[i], i));
        }
        return nsl;
    }
}
