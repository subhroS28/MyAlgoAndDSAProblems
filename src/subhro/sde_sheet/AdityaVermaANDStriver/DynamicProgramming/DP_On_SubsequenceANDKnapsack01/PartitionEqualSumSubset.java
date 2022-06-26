package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.Knapsack01;

/**
 * Question - https://leetcode.com/problems/partition-equal-subset-sum/
 */
public class PartitionEqualSumSubset {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for(int num : nums) sum += num;

        if(sum%2!=0) return false;
        return subSetSum(nums, (int)sum/2);
    }

    public boolean subSetSum(int[] nums, int target) {
        int len = nums.length;
        boolean[] prev = new boolean[target+1];

        //Base Condition
        prev[0] = true;

        if(nums[0]<=target) prev[nums[0]] = true;

        for(int i=1; i<len; i++){
            boolean[] temp = new boolean[target+1];
            temp[0] = true;
            for(int j=1; j<target+1; j++){
                boolean res1 = prev[j];
                boolean res2 = false;
                if(nums[i]<=j){
                    res2 = prev[j-nums[i]];
                }
                temp[j] = res1 || res2;
            }
            prev = temp;
        }

        return prev[target];
    }
}
