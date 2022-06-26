package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.Knapsack01;

/**
 * Question - https://leetcode.com/problems/target-sum/
 *
 * Same as divide the array into 2 subset with difference as target
 */
public class TargetSum {
    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();
        int[] nums = new int[]{1,1,1,1,1};
        System.out.print(targetSum.findTargetSumWays(nums, 3)); //5
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums) sum += num;

        if(target>sum || (sum-target)%2==1) return -1;

        int req = (sum-target)/2;
        return subarraySum(nums, req);
    }

    public int subarraySum(int nums[], int target) {
        int mod = (int)1e9+7;
        int len = nums.length;
        int[] prev = new int[target+1];

        //Base Condition
        if(nums[0]==0) prev[0] = 2;
        else prev[0] = 1;

        if(nums[0]!=0 && nums[0]<=target) prev[nums[0]] = 1;

        for(int i=1; i<len; i++){
            int[] temp = new int[target+1];
            for(int j=0; j<target+1; j++){
                int res1 = prev[j];
                int res2 = 0;
                if(nums[i]<=j){
                    res2 = prev[j-nums[i]];
                }
                temp[j] = (res1 + res2)%mod;
            }
            prev = temp;
        }

        return prev[target];
    }
}
