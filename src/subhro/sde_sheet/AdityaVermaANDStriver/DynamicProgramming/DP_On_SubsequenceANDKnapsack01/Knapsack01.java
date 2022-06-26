package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.Knapsack01;

/**
 * Question - https://www.codingninjas.com/codestudio/problems/0-1-knapsack_920542
 */
public class Knapsack01 {
    //Recursion
    int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        return knapsackHelper(weight, value, n-1, maxWeight);
    }

    private int knapsackHelper(int[] weight, int[] value, int index, int maxWeight) {
        if(maxWeight==0) return 0;
        if(index==0){
            if(weight[index]<=maxWeight){
                return value[index];
            }
            return 0;
        }

        int notPick = 0 + knapsackHelper(weight, value, index-1, maxWeight);
        int pick = 0;
        if(weight[index]<=maxWeight){
            pick = value[index] + knapsackHelper(weight, value, index-1, maxWeight-weight[index]);
        }

        return Math.max(pick, notPick);
    }

    //Memoization
    int knapsack2(int[] weight, int[] value, int n, int maxWeight) {
        return knapsackHelper2(weight, value, n-1, maxWeight, new Integer[n][maxWeight+1]);
    }

    private int knapsackHelper2(int[] weight, int[] value, int index, int maxWeight, Integer[][] dp) {
        if(maxWeight==0) return 0;
        if(index==0){
            if(weight[index]<=maxWeight){
                return value[index];
            }
            return 0;
        }

        if(dp[index][maxWeight]!=null) return dp[index][maxWeight];

        int notPick = 0 + knapsackHelper2(weight, value, index-1, maxWeight, dp);
        int pick = 0;
        if(weight[index]<=maxWeight){
            pick = value[index] + knapsackHelper2(weight, value, index-1, maxWeight-weight[index], dp);
        }

        dp[index][maxWeight] = Math.max(pick, notPick);
        return dp[index][maxWeight];
    }

    //Tabulation
    int knapsack3(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight+1];

        /* this can be skipped as default value of int is 0
        for(int i=0; i<n; i++){
            dp[i][0] = 0;
        }*/

        for(int i=weight[0]; i<maxWeight+1; i++){
            dp[0][i] = value[0];
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<maxWeight+1; j++){
                int notPick = 0 + dp[i-1][j];
                int pick = 0;
                if(weight[i]<=j){
                    pick = value[i] + dp[i-1][j-weight[i]];
                }

                dp[i][j] = Math.max(pick, notPick);
            }
        }

        return dp[n-1][maxWeight];
    }

    //Tabulation + Space Optimisation
    int knapsack4(int[] weight, int[] value, int n, int maxWeight) {
        int[] prev = new int[maxWeight+1];

        for(int i=weight[0]; i<maxWeight+1; i++){
            prev[i] = value[0];
        }

        for(int i=1; i<n; i++){
            int[] temp = new int[maxWeight+1];
            for(int j=0; j<maxWeight+1; j++){
                int notPick = 0 + prev[j];
                int pick = 0;
                if(weight[i]<=j){
                    pick = value[i] + prev[j-weight[i]];
                }

                temp[j] = Math.max(pick, notPick);
            }
            prev = temp;
        }

        return prev[maxWeight];
    }
}
