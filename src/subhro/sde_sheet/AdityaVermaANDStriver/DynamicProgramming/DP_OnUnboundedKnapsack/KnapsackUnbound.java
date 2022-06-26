package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.UnboundedKnapsack;

/**
 * Question - https://www.codingninjas.com/codestudio/problems/unbounded-knapsack_1215029?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
 *
 */
public class KnapsackUnbound {
    //Recursion
    public int unboundedKnapsack(int n, int maxWeight, int[] profit, int[] weight) {
        return knapsackHelper(weight, profit, n-1, maxWeight);
    }

    private int knapsackHelper(int[] weight, int[] value, int index, int maxWeight) {
        if(maxWeight==0) return 0;
        /*
        if(index==0){
            if(weight[index]<=maxWeight){
                return value[index];
            }
            return 0;
        }*/
        if(index==0){
            return (int)(maxWeight/weight[index])*value[index];
        }

        int notPick = 0 + knapsackHelper(weight, value, index-1, maxWeight);
        int pick = Integer.MIN_VALUE;
        if(weight[index]<=maxWeight){
            pick = value[index] + knapsackHelper(weight, value, index, maxWeight-weight[index]);
        }

        return Math.max(pick, notPick);
    }

    //Memoization
    public int unboundedKnapsack2(int n, int maxWeight, int[] profit, int[] weight) {
        return knapsackHelper(weight, profit, n-1, maxWeight, new Integer[n][maxWeight+1]);
    }

    private int knapsackHelper(int[] weight, int[] value, int index, int maxWeight, Integer[][] dp) {
        if(maxWeight==0) return 0;
        /*
        if(index==0){
            if(weight[index]<=maxWeight){
                return value[index];
            }
            return 0;
        }*/
        if(index==0){
            return (int)(maxWeight/weight[0])*value[0];
        }

        if(dp[index][maxWeight]!=null) return dp[index][maxWeight];

        int notPick = 0 + knapsackHelper(weight, value, index-1, maxWeight, dp);
        int pick = Integer.MIN_VALUE;
        if(weight[index]<=maxWeight){
            pick = value[index] + knapsackHelper(weight, value, index, maxWeight-weight[index], dp);
        }

        dp[index][maxWeight] = Math.max(pick, notPick);
        return dp[index][maxWeight];
    }

    //Tabulation
    public int unboundedKnapsack3(int n, int maxWeight, int[] profit, int[] weight) {
        int[][] dp = new int[n][maxWeight+1];

        //Base Condition
        for(int i=0; i<=maxWeight; i++){
            dp[0][i] = (i/weight[0])*profit[0];
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<= maxWeight; j++){
                int notPick = 0 + dp[i-1][j];
                int pick = Integer.MIN_VALUE;
                if(weight[i]<=j){
                    pick = profit[i] + dp[i][j-weight[i]];
                }

                dp[i][j] = Math.max(pick, notPick);
            }
        }

        return dp[n][maxWeight];
    }

    //Tabulation + Spaceoptimization [2D Array]
    public int unboundedKnapsack4(int n, int maxWeight, int[] profit, int[] weight) {
        int[] prev = new int[maxWeight+1];

        //Base Condition
        for(int i=0; i<=maxWeight; i++){
            prev[i] = (i/weight[0])*profit[0];
        }

        for(int i=1; i<n; i++){
            int[] curr = new int[maxWeight+1];
            for(int j=0; j<= maxWeight; j++){
                int notPick = 0 + prev[j];
                int pick = Integer.MIN_VALUE;
                if(weight[i]<=j){
                    pick = profit[i] + curr[j-weight[i]];
                }

                curr[j] = Math.max(pick, notPick);
            }
            prev = curr;
        }

        return prev[maxWeight];
    }

    //Tabulation + Spaceoptimization [1D Array]
    public int unboundedKnapsack5(int n, int maxWeight, int[] profit, int[] weight) {
        int[] prev = new int[maxWeight+1];

        //Base Condition
        for(int i=0; i<=maxWeight; i++){
            prev[i] = (i/weight[0])*profit[0];
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<= maxWeight; j++){
                int notPick = 0 + prev[j];
                int pick = Integer.MIN_VALUE;
                if(weight[i]<=j){
                    pick = profit[i] + prev[j-weight[i]];
                }

                prev[j] = Math.max(pick, notPick);
            }
        }

        return prev[maxWeight];
    }
}
