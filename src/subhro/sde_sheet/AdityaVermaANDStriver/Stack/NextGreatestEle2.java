package subhro.sde_sheet.AdityaVermaANDStriver.Stack;

import java.util.*;

/**
 * Question - https://leetcode.com/problems/next-greater-element-ii/
 *
 * Video - https://www.youtube.com/watch?v=RkG94TvnUFs&ab_channel=Pepcoding
 *
 * Blog - https://www.geeksforgeeks.org/find-the-next-greater-element-in-a-circular-array/
 *        https://www.geeksforgeeks.org/find-the-next-greater-element-in-a-circular-array-set-2/
 */
public class NextGreatestEle2 {

    //Same logic. just that code is reduced
    public int[] nextGreaterElements2(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;
        int[] req = new int[len];

        //This is only for circular
        //He are pre requisitly checking element greater than last ele
        for(int i=len-2; i>=0; i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i]){
                stack.pop();
            }
            stack.push(nums[i]);
        }

        for(int i=len-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i]){
                stack.pop();
            }

            req[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return req;
    }

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;
        int[] req = new int[len];

        //This is only for circular
        //Here pre requisitly checking element greater than last ele
        for(int i=len-2; i>=0; i--){
            while(stack.size()>0 && stack.peek()<=nums[i]){
                stack.pop();
            }
            stack.push(nums[i]);
        }

        for(int i=len-1; i>=0; i--){
            int size = stack.size();
            if(size==0){
                if(i==len-1 && req[len-1]>0){
                    //do nothing
                }else{
                    req[i] = -1;
                }
            }else if(size>0 && stack.peek()>nums[i]){
                req[i]=stack.peek();
            }else if(size>0 && stack.peek()<=nums[i]){
                while(stack.size()>0 && stack.peek()<=nums[i]){
                    stack.pop();
                }

                int subSize = stack.size();
                if(subSize==0){
                    req[i] = -1;
                }else if(subSize>0 && stack.peek()>nums[i]){
                    req[i]=stack.peek();
                }
            }

            stack.push(nums[i]);
        }

        return req;
    }

    public static void main(String[] args) {
        NextGreatestEle2 nextGreatestEle2 = new NextGreatestEle2();
        int[] ele = new int[]{1,2,4,5,3};
        int[] ints = nextGreatestEle2.nextGreaterElements(ele);
        System.out.print("[ ");
        for (int num : ints){
            System.out.print(num+" ");
        }
        System.out.print("]");
    }
}
