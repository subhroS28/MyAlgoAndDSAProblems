package subhro.sde_sheet.AdityaVermaANDStriver.Stack;

import java.util.Stack;

/**
 * Question - https://practice.geeksforgeeks.org/problems/fab3dbbdce746976ba35c7b9b24afde40eae5a04/1/
 *
 * Blog - https://www.geeksforgeeks.org/next-smaller-element/
 */
public class NextSmallestEleInRight {
    public static int[] help_classmate(int a[], int n)
    {
        Stack<Integer> stack = new Stack<>();
        int[] req = new int[n];

        int len = n;
        for(int i=len-1; i>=0; i--){
            while(stack.size()>0 && stack.peek()>=a[i]){
                stack.pop();
            }

            int nextSmallestEl = stack.size()==0 ? -1 : stack.peek();
            req[i] = nextSmallestEl;
            stack.push(a[i]);
        }

        return req;
    }
}
