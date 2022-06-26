package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.DP_OnStocks;

/**
 * Question - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class BuyAndSell3 {
    //Recursion
    public int maxProfit(int[] prices) {
        int len = prices.length;
        return maxProfitHelper(prices, 0, len, 2, 1);
    }

    private int maxProfitHelper(int[] prices, int index, int len, int totalBuy, int buy) {
        if(totalBuy==0 || index == len){
            return 0;
        }

        int res;
        if(buy==1){
            res = Math.max(-prices[index] + maxProfitHelper(prices, index+1, len, totalBuy, 0),
                    0 + maxProfitHelper(prices, index+1, len, totalBuy, 1));
        }else{
            res = Math.max(prices[index] + maxProfitHelper(prices, index+1, len, totalBuy-1, 1),
                    0 + maxProfitHelper(prices, index+1, len, totalBuy, 0));
        }
        return res;
    }


    //Memoization
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        return maxProfitHelper(prices, 0, len, 2, 1, new Integer[len+1][2][3]);
    }

    private int maxProfitHelper(int[] prices, int index, int len, int totalBuy, int buy, Integer[][][] dp) {
        if(totalBuy==0 || index == len){
            return 0;
        }

        if(dp[index][buy][totalBuy]!=null) return dp[index][buy][totalBuy];

        int res;
        if(buy==1){
            res = Math.max(-prices[index] + maxProfitHelper(prices, index+1, len, totalBuy, 0, dp),
                    0 + maxProfitHelper(prices, index+1, len, totalBuy, 1, dp));
        }else{
            res = Math.max(prices[index] + maxProfitHelper(prices, index+1, len, totalBuy-1, 1, dp),
                    0 + maxProfitHelper(prices, index+1, len, totalBuy, 0, dp));
        }

        dp[index][buy][totalBuy] = res;
        return dp[index][buy][totalBuy];
    }

    //Tabulation
    public int maxProfit3(int[] prices) {
        int len = prices.length;
        int[][][] dp = new int[len+1][2][3];

        //Base Conditions
        //1. For totalBuy=0;
        for(int i=0; i<=len; i++){
            for (int j=0; j<=1; j++){
                dp[i][j][0] = 0;
            }
        }

        //2. For index==len
        for (int j=0; j<=1; j++){
            for(int k=0; k<=2; k++){
                dp[len][j][k] = 0;
            }
        }

        //NOTE: ABOVE BASE CASE [IN THIS QUESTION] WILL NOT BE NEEDED AS WE ARE SETTING UP VALUE TO 0 [WHICH IS A DEFAULT VALUE OF INT]

        for(int i=len-1; i>=0; i--){
            for(int j=0; j<=1; j++){
                for (int k=1; k<=2; k++){
                    int res;
                    if(j==1){
                        res = Math.max(-prices[i] + dp[i+1][0][k], 0 + dp[i+1][1][k]);
                    }else{
                        res = Math.max(prices[i] + dp[i+1][1][k-1], 0 + dp[i+1][0][k]);
                    }

                    dp[i][j][k] = res;
                }
            }
        }

        return dp[0][1][2];
    }

    //Tabulation + Space Optimisation
    public int maxProfit4(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[2][3];

        //Base Conditions
        //1. For totalBuy=0;
        for (int j=0; j<=1; j++){
            dp[j][0] = 0;
        }

        //2. For index==len
        for (int j=0; j<=1; j++){
            for(int k=0; k<=2; k++){
                dp[j][k] = 0;
            }
        }

        //NOTE: ABOVE BASE CASE [IN THIS QUESTION] WILL NOT BE NEEDED AS WE ARE SETTING UP VALUE TO 0 [WHICH IS A DEFAULT VALUE OF INT]

        for(int i=len-1; i>=0; i--){
            int[][] curr = new int[2][3];
            for(int j=0; j<=1; j++){
                for (int k=1; k<=2; k++){
                    int res;
                    if(j==1){
                        res = Math.max(-prices[i] + dp[0][k], 0 + dp[1][k]);
                    }else{
                        res = Math.max(prices[i] + dp[1][k-1], 0 + dp[0][k]);
                    }

                    curr[j][k] = res;
                }
            }
            dp = curr;
        }

        return dp[1][2];
    }

}
