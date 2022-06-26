package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.UnboundedKnapsack;

/**
 * `DO IT AGAIN
 *
 * Question - https://www.codingninjas.com/codestudio/problems/rod-cutting-problem_800284?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
 *
 */
public class RodCuttingProblem {
    public static int cutRod(int price[], int n) {
        //Here in this question n and price.length are same
        return cutRodHelper(price, n, n-1, new Integer[n][n+1]);
    }

    private static int cutRodHelper(int[] price, int n, int index, Integer[][] dp) {
        if(n==0) return 0;
        if(index==0){
            return n * price[0];
        }

        if(dp[index][n]!=null) return dp[index][n];

        int notCut = cutRodHelper(price, n, index-1, dp);
        int cut = 0;
        if((index+1)<=n){
            cut = price[index] + cutRodHelper(price, n-index-1, index, dp);
        }

        dp[index][n] = Math.max(cut, notCut);
        return dp[index][n];
    }

    //Tabulation
    public static int cutRod2(int price[], int n) {
        int[][] dp = new int[n][n+1];

        //Base Condition
        for(int i=0; i<=n; i++){
            dp[0][i] = i * price[0];
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<=n; j++){
                int notCut = dp[i-1][j];
                int cut = 0;
                if((i+1)<=j){
                    cut = price[i] + dp[i][j-i-1];
                }
                dp[i][j] = Math.max(cut, notCut);
            }
        }

        return dp[price.length-1][n];
    }

    //Tabulation+ space optimisation
    public static int cutRod3(int price[], int n) {
        int[] prev = new int[n+1];

        //Base Condition
        for(int i=0; i<=n; i++){
            prev[i] = i * price[0];
        }

        for(int i=1; i<n; i++){
            int[] curr = new int[n+1];
            for(int j=0; j<=n; j++){
                int notCut = prev[j];
                int cut = 0;
                if((i+1)<=j){
                    cut = price[i] + curr[j-i-1];
                }
                curr[j] = Math.max(cut, notCut);
            }
            prev=curr;
        }

        return prev[n];
    }
}
