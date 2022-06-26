package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.Knapsack01;

/**
 * Question - https://www.codingninjas.com/codestudio/problems/partitions-with-given-difference_3751628?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0
 */
public class PartitionWithGivenDiff {
    public static int countPartitions(int n, int d, int[] arr) {
        int sum =0;
        for(int num : arr) sum += num;

        if( sum-d < 0 || (sum-d)%2==1) return 0;
        int target = (sum-d)/2;
        return subarraySum(arr, target);
    }

    public static int subarraySum(int nums[], int target) {
        int mod = (int)1e9+7;
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
                dp[i][j] = (res1 + res2)%mod;
            }
        }

        return dp[len-1][target];
    }

    //Tabulation + Space optimised
    public static int subarraySum2(int nums[], int target) {
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
