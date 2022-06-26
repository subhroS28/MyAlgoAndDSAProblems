package subhro.sde_sheet.AdityaVermaANDStriver.Stack;

import java.util.Stack;

/**
 * Question - https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1/#
 *
 * Blog - https://www.geeksforgeeks.org/next-greater-element/
 */
public class NextGreaterElement {
    public static long[] nextLargerElement(long[] nums, int n)
    {
        Stack<Long> stack = new Stack<>();
        int len = nums.length;
        long[] req = new long[len];

        for(int i=len-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i]){
                stack.pop();
            }

            req[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return req;
    }
}
