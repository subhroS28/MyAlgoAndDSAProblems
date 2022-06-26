package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.Basic1D;

import java.util.ArrayList;

/**
 * Question - https://leetcode.com/problems/house-robber-ii/
 *
 * Blog - https://takeuforward.org/data-structure/maximum-sum-of-non-adjacent-elements-dp-5/
 */
public class MaximumSumOfNonAdjacentElementsCircular {

    //SC - O(2N)
    public int rob(int[] nums) {
        int length = nums.length;
        if(length==1) return nums[0];
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        for(int i=0; i<length; i++){
            if(i!=0) arr1.add(nums[i]);
            if(i!=length-1) arr2.add(nums[i]);
        }
        return Math.max(robHelper(arr1, length-1), robHelper(arr2, length-1));
    }

    private int robHelper(ArrayList<Integer> arr, int n){
        int prev = arr.get(0);
        int prev2 = 0;

        for(int i=1; i<n; i++){
            prev2 += arr.get(i);
            int curr = Math.max(prev2, prev);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    //SC - O(1)
    public int rob2(int[] nums) {
        return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
    }

    public int rob(int[] nums, int lo, int hi) {
        int preRob = 0, preNotRob = 0, rob = 0, notRob = 0;
        for (int i = lo; i <= hi; i++) {
            rob = preNotRob + nums[i];
            notRob = Math.max(preRob, preNotRob);

            preNotRob = notRob;
            preRob = rob;
        }
        return Math.max(rob, notRob);
    }
}
