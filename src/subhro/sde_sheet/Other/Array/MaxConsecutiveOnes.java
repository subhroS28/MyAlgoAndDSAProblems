package subhro.sde_sheet.day7_twoPointer;

/**
 * NOTE: - This will be warmup question so try to solve it fast
 *
 * Question - https://leetcode.com/problems/max-consecutive-ones/
 *
 * Approach - 1. Optimal approach - TC - O(N) AND SC - O(1)
 *
 * Video - https://www.youtube.com/watch?v=Mo33MjjMlyA&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=44&ab_channel=takeUforward
 */
public class MaxConsecutiveOnes {

    //Optimal APPROACH
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        if(len==0){
            return 0;
        }

        int res = 0;
        int currRes = 0;
        for(int i=0;i<len;i++){
            if(nums[i]==1){
                currRes++;
            }else{
                currRes = 0;
            }
            res = Math.max(currRes, res);
        }

        return res;
    }
}
