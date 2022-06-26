package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.DP_OnStocks;

/**
 * Question - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class BuyAndSell4 {
    //Memoization [Same as BuyAndSell3]
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        return maxProfitHelper(prices, 0, len, k, 1, new Integer[len+1][2][k+1]);
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
    public int maxProfit2(int cap, int[] prices) {
        int len = prices.length;
        int[][][] dp = new int[len+1][2][cap+1];

        //As base case is having 0 so lets leave it

        for(int i=len-1; i>=0; i--){
            for(int j=0; j<=1; j++){
                for(int k=1; k<=cap; k++){
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

        return dp[0][1][cap];
    }
}
