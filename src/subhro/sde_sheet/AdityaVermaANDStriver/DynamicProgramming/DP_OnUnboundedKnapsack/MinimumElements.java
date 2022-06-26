package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.DP_On_SubsequenceANDKnapsack01;

public class MinimumElements {
    public static int minimumElements(int nums[], int x) {
        int size = nums.length;
        int ans= minimumElementsHelper(nums, x, size-1, new Integer[size][x+1]);
        if(ans>=(int)1e9){
            return -1;
        }else{
            return ans;
        }
    }

    private static int minimumElementsHelper(int[] nums, int x, int index, Integer[][] dp){
        if(index==0){
            if(x%nums[0]==0){
                return x/nums[0];
            }else{
                return (int)1e9;
            }
        }

        if(dp[index][x]!=null){
            return dp[index][x];
        }

        int notTake = minimumElementsHelper(nums, x, index-1, dp);
        int take=Integer.MAX_VALUE;
        if(nums[index]<=x){
            take = 1 + minimumElementsHelper(nums, x - nums[index], index, dp);
        }
        dp[index][x] = Math.min(take, notTake);
        return dp[index][x];
    }

    public static int minimumElements2(int nums[], int x) {
        int size = nums.length;
        int[][] dp = new int[size][x+1];

        for(int i=0; i<=x; i++){
            if(i%nums[0]==0){
                dp[0][i] = i/nums[0];
            }else{
                dp[0][i] = (int)1e9;
            }
        }

        for(int i=1; i<size; i++){
            for(int j=0; j<=x; j++){
                int notTake = dp[i-1][j];
                int take=Integer.MAX_VALUE;
                if(nums[i]<=j){
                    take = 1 + dp[i][j-nums[i]];
                }
                dp[i][j] = Math.min(take, notTake);
            }
        }

        return dp[size-1][x] >= (int)1e9 ? -1 : dp[size-1][x];
    }

    //Space optimised
    public static int minimumElements3(int nums[], int x) {
        int size = nums.length;
        int[] dp = new int[x+1];

        for(int i=0; i<=x; i++){
            if(i%nums[0]==0){
                dp[i] = i/nums[0];
            }else{
                dp[i] = (int)1e9;
            }
        }

        for(int i=1; i<size; i++){
            int[] curr = new int[x+1];
            for(int j=0; j<=x; j++){
                int notTake = dp[j];
                int take=Integer.MAX_VALUE;
                if(nums[i]<=j){
                    take = 1 + curr[j-nums[i]];
                }
                curr[j] = Math.min(take, notTake);
            }
            dp = curr;
        }

        return dp[x] >= (int)1e9 ? -1 : dp[x];
    }
}
