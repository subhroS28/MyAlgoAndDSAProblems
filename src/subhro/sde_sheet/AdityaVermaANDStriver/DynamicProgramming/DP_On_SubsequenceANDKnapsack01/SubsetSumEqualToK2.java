package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.Knapsack01;

/**
 * Question - https://www.codingninjas.com/codestudio/problems/number-of-subsets_3952532?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0
 *
 * NOTE - BELOW ANSWER WILL WORK FOR numbers greater than or equal to 1 as for 0 and for negative number condition will be d/f
 *
 */
public class SubsetSumEqualToK2 {
    public int subarraySum(int[] nums, int k) {
        return subarraySumHelper(nums, k, nums.length-1);
    }

    private int subarraySumHelper(int[] nums, int k, int index) {
        if(k==0) return 1;
        if(index==0){
            if(k==nums[0]){
                return 1;
            }else{
                return 0;
            }
        }

        int res1 = subarraySumHelper(nums, k, index-1);
        int res2 = 0;
        if(nums[index]<=k){
            res2 = subarraySumHelper(nums, k-nums[index], index-1);
        }

        return res1+res2;
    }

    //Tabulation
    public static int subarraySum2(int nums[], int target) {
        int len = nums.length;
        int[][] dp = new int[len][target+1];

        //Base Condition
        for(int i=0; i<len; i++){
            dp[i][0] = 1;
        }
        if(nums[0]<=target) dp[0][nums[0]] = 1;

        for(int i=1; i<len; i++){
            for(int j=1; j<target+1; j++){
                int res1 = dp[i-1][j];
                int res2 = 0;
                if(nums[i]<=j){
                    res2 = dp[i-1][j-nums[i]];
                }
                dp[i][j] = res1 + res2;
            }
        }

        return dp[len-1][target];
    }

    //Tabulation + Space Optimised
    public static int subarraySum3(int nums[], int target) {
        int len = nums.length;
        int[] prev = new int[target+1];

        //Base Condition
        prev[0] = 1;
        if(nums[0]<=target) prev[nums[0]] = 1;

        for(int i=1; i<len; i++){
            int[] temp = new int[target+1];
            temp[0] = 1;
            for(int j=1; j<target+1; j++){
                int res1 = prev[j];
                int res2 = 0;
                if(nums[i]<=j){
                    res2 = prev[j-nums[i]];
                }
                temp[j] = res1 + res2;
            }
            prev = temp;
        }

        return prev[target];
    }




    /**
     * For Input having 0
     * Note for this case in tabulation the 2nd loop [i.e. j in this case should start from 0 rather then 1]
     * because in the case of number greater then 0 for j==0 it is always 1 but for number starting from 0
     * it can be 2 also
     */

    public int subarraySum4(int[] nums, int k) {
        return subarraySumHelper2(nums, k, nums.length-1);
    }

    private int subarraySumHelper2(int[] nums, int k, int index) {
        /* This will work for input nums >=1 not for 0
        if(k==0) return 1;
        if(index==0){
            if(k==nums[0]){
                return 1;
            }else{
                return 0;
            }
        }*/

        /* for Zero condition will be */
        if(index==0){
            if(k==0 && nums[0]==0) return 2;
            if(k==0 || nums[0]==k) return 1;
            return 0;
        }

        int res1 = subarraySumHelper2(nums, k, index-1);
        int res2 = 0;
        if(nums[index]<=k){
            res2 = subarraySumHelper2(nums, k-nums[index], index-1);
        }

        return res1+res2;
    }

    //Tabulation
    public static int subarraySum5(int nums[], int target) {
        int len = nums.length;
        int[][] dp = new int[len][target+1];

        /*This will not work
        //Base Condition
        for(int i=0; i<len; i++){
            dp[i][0] = 1;
        }
        if(nums[0]<=target) dp[0][nums[0]] = 1;
        */

        //Base Condition
        if(nums[0]==0) dp[0][0] = 2;
        else dp[0][0] = 1;

        if(nums[0]!=0 && nums[0]<=target) dp[0][nums[0]] = 1;

        for(int i=1; i<len; i++){
            for(int j=0; j<target+1; j++){
                int res1 = dp[i-1][j];
                int res2 = 0;
                if(nums[i]<=j){
                    res2 = dp[i-1][j-nums[i]];
                }
                dp[i][j] = res1 + res2;
            }
        }

        return dp[len-1][target];
    }

    //Tabulation + Space Optimised
    public static int subarraySum6(int nums[], int target) {
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
