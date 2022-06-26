package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.DP_OnStocks;

/**
 * Same as BuyAndSell2, just with small modifications
 * Question - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class BuyAndSellStockWithCooldown {
    //Memoization
    public int maxProfit(int[] prices) {
        int len = prices.length;
        return maxProfitHelper(prices, 0, 1, len, new Integer[len+1][2]);
    }

    private int maxProfitHelper(int[] prices, int index, int buy, int len, Integer[][] dp) {
        if(index>=len) return 0;

        if(dp[index][buy]!=null) return dp[index][buy];

        int res;
        if(buy==1){
            res = Math.max(-prices[index] + maxProfitHelper(prices, index+1, 0, len, dp),
                    0 + maxProfitHelper(prices, index+1, 1, len, dp));
        }else {
            res = Math.max(prices[index] + maxProfitHelper(prices, index+2, 1, len, dp),
                    0 + maxProfitHelper(prices, index+1, 0, len, dp));
        }

        dp[index][buy] = res;
        return dp[index][buy];
    }

    //Tabulation
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len+1][2];

        for(int i=len-1; i>=0; i--){
            for (int buy=0; buy<=1; buy++){
                int res;
                if(buy==1){
                    res = Math.max(-prices[i] + dp[i+1][0], 0 + dp[i+1][1]);
                }else {
                    int subCom = 0;
                    if(i+2<=len){
                        subCom = dp[i+2][1];
                    }
                    res = Math.max(prices[i] + subCom, 0 + dp[i+1][0]);
                }

                dp[i][buy] = res;
            }
        }

        return dp[0][1];
    }

    //NOTE: In this doing space optimisation will be not as normal as we do, as here we want to have value of (index+2)
    //because of index+2, we would need prev, prev2 and curr. prev2 for index+2 val
    //Tabulation + Space Optimisation
    public int maxProfit3(int[] prices) {
        int len = prices.length;
        int[] dp = new int[2];
        int[] dp2 = new int[2];

        for(int i=len-1; i>=0; i--){
            int[] curr = new int[2];
            for (int buy=0; buy<=1; buy++){
                int res;
                if(buy==1){
                    res = Math.max(-prices[i] + dp[0], 0 + dp[1]);
                }else {
                    int subCom = 0;
                    if(i+2<=len){
                        subCom = dp2[1];
                    }
                    res = Math.max(prices[i] + subCom, 0 + dp[0]);
                }

                curr[buy] = res;
            }
            dp2 = dp;
            dp = curr;
        }

        return dp[1];
    }
}
