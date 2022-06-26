package subhro.sde_sheet.AdityaVermaANDStriver.SlidingWindow.FixedSize;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Question - https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
 *            https://leetcode.com/problems/sliding-window-maximum/
 *
 *  Best Explanation - https://leetcode.com/problems/sliding-window-maximum/discuss/458121/Java-All-Solutions-(B-F-PQ-Deque-DP)-with-Explanation-and-Complexity-Analysis
 *
 */
public class MaximumOfAllSubarraysOfSizek {
    public static void main(String[] args) {
        int arr[] = new int[]{1,3,-1,-3,5,3,6,7};
        int k=3;
        int[] ans = maxSlidingWindow(arr, k);
        for(int num : ans){
            System.out.println(num);
        }
    }

    static public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;

        if(len<k || len==0 || k==0){
            return new int[0];
        }

        int[] ans = new int[len-k+1];
        Deque<Integer> helper = new ArrayDeque<>();
        int i=0;
        int j=0;
        // int counter=0;
        while(j<len){
            while(!helper.isEmpty() && helper.peekFirst() < j-k+1){
                helper.pollFirst();
            }

            while(!helper.isEmpty() && nums[j]>nums[helper.peekLast()]){
                helper.pollLast();
            }

            helper.add(j);
            if(j-i+1==k){
                ans[j-k+1] = nums[helper.peekFirst()];
                i++;
            }
            j++;
        }

        return ans;
    }


    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k){
        ArrayList<Integer> res = new ArrayList<>();
        if(n==1){
            res.add(arr[0]);
            return res;
        }
        Deque<Integer> helper = new ArrayDeque<>();
        int i=0;
        int j=0;
        while(j<n){
            while(!helper.isEmpty()&&helper.peek()<j-k+1){
                helper.poll();
            }

            while(!helper.isEmpty()&&arr[helper.peekLast()]<arr[j]){
                helper.pollLast();
            }
            helper.offer(j);

            if(j-i+1==k){
                res.add(arr[helper.peek()]);
                i++;
            }
            j++;
        }
        return res;
    }

}
