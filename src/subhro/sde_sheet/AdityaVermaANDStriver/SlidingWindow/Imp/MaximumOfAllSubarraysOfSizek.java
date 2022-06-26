package subhro.sde_sheet.AdityaVermaANDStriver.SlidingWindow.Imp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Question - https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
 *            https://leetcode.com/problems/sliding-window-maximum/
 *
 *  Best Explanation - https://leetcode.com/problems/sliding-window-maximum/discuss/458121/Java-All-Solutions-(B-F-PQ-Deque-DP)-with-Explanation-and-Complexity-Analysis
 *                     https://leetcode.com/problems/sliding-window-maximum/discuss/66026/Important-to-talk-about-the-solution-(Brute-Force-vs-Deque-Method)-in-Java
 *
 */
public class MaximumOfAllSubarraysOfSizek {

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
            //This below code is used to remove the ith element from deque.
            while(!helper.isEmpty()&&helper.peek()<j-k+1){
                helper.poll();
            }

            //This is used to remove the nums which are smaller in deque and will keep on removing till bigger num comes
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
