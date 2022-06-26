package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.Knapsack01;

/**
 * Question - https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1/#
 */
public class SubsetSumEqualToK {
    public boolean subarraySum(int[] nums, int k) {
        return subarraySumHelper(nums, k, nums.length-1);
    }

    private boolean subarraySumHelper(int[] nums, int k, int index) {
        if(k==0) return true;
        if(index==0) return k==nums[0];

        boolean res1 = subarraySumHelper(nums, k, index-1);
        boolean res2 = false;
        if(nums[index]<=k){
            res2 = subarraySumHelper(nums, k-nums[index], index-1);
        }

        return res1 || res2;
    }

    //Memoization
    public boolean subarraySum2(int[] nums, int target) {
        return subarraySumHelper(nums, target, nums.length-1, new Boolean[nums.length][target+1]);
    }

    private static boolean subarraySumHelper(int[] nums, int k, int index, Boolean[][] dp) {
        if(k==0) return true;
        if(index==0) return k==nums[0];

        if(dp[index][k] != null) return dp[index][k];

        boolean res1 = subarraySumHelper(nums, k, index-1, dp);
        boolean res2 = false;
        if(nums[index]<=k){
            res2 = subarraySumHelper(nums, k-nums[index], index-1, dp);
        }

        dp[index][k] = res1 || res2;
        return dp[index][k];
    }

    //Tabulation
    public boolean subarraySum3(int[] nums, int target) {
        int len = nums.length;
        boolean[][] dp = new boolean[len][target+1];

        //Base Condition
        for(int i=0; i<len; i++){
            dp[i][0] = true;
        }

        if(nums[0]<=target) dp[0][nums[0]] = true;

        for(int i=1; i<len; i++){
            for(int j=1; j<target+1; j++){
                boolean res1 = dp[i-1][j];
                boolean res2 = false;
                if(nums[i]<=j){
                    res2 = dp[i-1][j-nums[i]];
                }
                dp[i][j] = res1 || res2;
            }
        }

        return dp[len-1][target];
    }

    //Tabulation + optimization
    public boolean subarraySum4(int[] nums, int target) {
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
