package subhro.sde_sheet.AdityaVermaANDStriver.DynamicProgramming.DP_OnStocks;

/**
 * Question - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BuyAndSell2 {

    //RECURSION [FROM MYSELF]
    public int maxProfit(int[] prices) {
        return maxProfitHelper(prices, 0, prices.length, Integer.MAX_VALUE);
    }

    private int maxProfitHelper(int[] prices, int index, int length, int min) {
        if(index==prices.length-1){
            if(prices[index]<min){
                min = prices[index];
            }
            return prices[index] - min;
        }

        if(prices[index]<min){
            min = prices[index];
        }

        return Math.max(prices[index] - min + maxProfitHelper(prices, index+1, length, Integer.MAX_VALUE), 0 + maxProfitHelper(prices, index+1, length, min));
    }

    //Recursion [From Striver]
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        return maxProfitHelper(prices, 0, 1, len, new Integer[len+1][2]);
    }

    private int maxProfitHelper(int[] prices, int index, int buy, int len, Integer[][] dp) {
        if(index==len) return 0;

        if(dp[index][buy]!=null) return dp[index][buy];

        int res;
        if(buy==1){
            res = Math.max(-prices[index] + maxProfitHelper(prices, index+1, 0, len, dp),
                    0 + maxProfitHelper(prices, index+1, 1, len, dp));
        }else {
            res = Math.max(prices[index] + maxProfitHelper(prices, index+1, 1, len, dp),
                    0 + maxProfitHelper(prices, index+1, 0, len, dp));
        }

        dp[index][buy] = res;
        return dp[index][buy];
    }

    //Tabulation
    public int maxProfit3(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len+1][2];

        //Base Case
        //As base case's value is 0 so need to do anything
        dp[len][0] = dp[len][1] = 0;

        //Now as in recursion the direction is from 0 to n so in loop it will be n to 0
        for(int i=len-1; i>=0; i--){
            for (int j=0; j<=1; j++){
                int res;
                if(j==1){
                    res = Math.max(-prices[i] + dp[i+1][0], 0 + dp[i+1][1]);
                }else {
                    res = Math.max(prices[i] + dp[i+1][1], 0 + dp[i+1][0]);
                }

                dp[i][j] = res;
            }
        }

        //Now as in recursion the direction is from 0 to n so result will be in dp[0][1] rather then dp[len][1]
        return dp[0][1];
    }

    //Tabulation + SpaceOptimisation
    public int maxProfit4(int[] prices) {
        int len = prices.length;
        int[] prev = new int[2];

        //Base Case
        //As base case's value is 0 so need to do anything
        prev[0] = prev[1] = 0;

        //Now as in recursion the direction is from 0 to n so in loop it will be n to 0
        for(int i=len-1; i>=0; i--){
            int curr[] = new int[2];
            for (int j=0; j<=1; j++){
                int res;
                if(j==1){
                    res = Math.max(-prices[i] + prev[0], 0 + prev[1]);
                }else {
                    res = Math.max(prices[i] + prev[1], 0 + prev[0]);
                }

                curr[j] = res;
            }
            prev = curr;
        }

        //Now as in recursion the direction is from 0 to n so result will be in prev[0][1] rather then prev[len][1]
        return prev[1];
    }
}
