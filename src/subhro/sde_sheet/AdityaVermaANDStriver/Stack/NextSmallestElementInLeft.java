package subhro.sde_sheet.AdityaVermaANDStriver.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Question - https://practice.geeksforgeeks.org/problems/smallest-number-on-left3403/1/
 *
 * Blog - https://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/
 *
 */
public class NextSmallestElementInLeft {
    static List<Integer> leftSmaller(int n, int a[])
    {
        Stack<Integer> stack = new Stack<>();
        List<Integer> req = new ArrayList<>();

        int len = a.length;
        for(int i=0; i<len; i++){
            while(stack.size()>0 && stack.peek()>=a[i]){
                stack.pop();
            }

            int nextSmallestEl = stack.size()==0 ? -1 : stack.peek();
            req.add(nextSmallestEl);
            stack.push(a[i]);
        }

        return req;
    }
}
